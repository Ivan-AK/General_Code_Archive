#!/usr/bin/python3

# Import modules for CGI handling
import cgi
import cgitb; cgitb.enable()
import numpy
import Gnuplot, pygnuplot
import sys
import os
#import base64

# Create instance of FieldStorage
form = cgi.FieldStorage()

#this is the function that creates the gnuplot script that creates the graph png
def generate_graph(timestamps, data_list, name, ylabel):
    temp_data_file = "/home/ivan/public_html/temp_files/temp_data_file.txt"
    f = open(temp_data_file,'w')
    for i in range(0, len(data_list) - 1):
        f.write (timestamps[i] + " " + str(data_list[i]) + "\n")
    f.close()
    xrange_low = timestamps[0]
    xrange_high = timestamps[len(timestamps)-1]
    xrange= "set xrange [\""+xrange_low+"\":\""+""+xrange_high+"\"]"
    gnuplot_script_path = "/home/ivan/public_html/temp_files/" + name + ".gp"
    g = open(gnuplot_script_path,'w')
    g.write ("#!/usr/bin/gnuplot\n")
    g.write ("set title(\"" + name + "\")\n")
    g.write ("set xlabel(\"Date\") font \",10\"\n")
    g.write ("set xtics rotate\n")
    g.write ("set ylabel(\"" + ylabel + "\")\n")
    g.write ("set grid\n")
    #g.write ("set ytic " + ytic + "\n")
    g.write ("set xdata time\n")
    g.write ("set format x \"%m/%d/%Y\"\n")
    g.write ("set timefmt \"%m/%d/%Y %H:%M\"\n")
    g.write ("set style data lines\n")
    g.write ("set term png\n")
    g.write ("set output \"/home/ivan/public_html/wdi/wdi_images/" + name + ".png\"\n")
    g.write ("plot \"/home/ivan/public_html/temp_files/temp_data_file.txt\" using 1:3 with linespoints title \"" + name + "\"\n")
    g.close()
    os.system('chmod +x '+ gnuplot_script_path) #make it executable
    os.system(gnuplot_script_path) # run the script
    #sys.exit(0)
    #os.remove(temp_data_file)

# Get data from fields
#dropdowns
start_year = str(form.getvalue('start_year'))
start_month  = str(form.getvalue('start_month'))
start_day = str(form.getvalue('start_day'))
end_year = str(form.getvalue('end_year'))
end_month = str(form.getvalue('end_month'))
end_day = str(form.getvalue('end_day'))

#checkboxes
if form.getvalue('temperature'):
   temp_flag = "ON"
else:
   temp_flag = "OFF"
if form.getvalue('humidity'):
   humidity_flag = "ON"
else:
   humidity_flag = "OFF"
if form.getvalue('dew_point'):
   dew_flag = "ON"
else:
   dew_flag = "OFF"
if form.getvalue('heat_index'):
   heat_flag = "ON"
else:
   heat_flag = "OFF"
if form.getvalue('wind_chill'):
   wind_chill_flag = "ON"
else:
   wind_chill_flag = "OFF"
if form.getvalue('barometric_pressure'):
   pressure_flag = "ON"
else:
   pressure_flag = "OFF"
if form.getvalue('rainfall'):
   rain_flag = "ON"
else:
   rain_flag = "OFF"
if form.getvalue('wind_speed'):
   wind_speed_flag = "ON"
else:
   wind_speed_flag = "OFF"
if form.getvalue('wind_average'):
   wind_average_flag = "ON"
else:
   wind_average_flag = "OFF"
if form.getvalue('wind_peak'):
   wind_peak_flag = "ON"
else:
   wind_peak_flag = "OFF"
if form.getvalue('wind_direction'):
   wind_dir_flag = "ON"
else:
   wind_dir_flag = "OFF"

#Translation of dates into usable integers
start_date = int(start_year + start_month + start_day)
end_date = int(end_year + end_month + end_day)
if start_date == end_date:
    exit()
if start_date > end_date:
    exit()
file_dates = []
files_temp = os.listdir("../../weather/data.bak/")
files_temp.sort()
files = []
for filename in files_temp:
    if ("weather-20" in filename):
        files.append(filename)
selected_files = []
loop_trigger = False
for i in range(0, len(files)):
    if int(files[i][8:16]) >= start_date:
        if loop_trigger == False:
            selected_files.append(files[i-1])
            loop_trigger = True
        if int(files[i][8:16]) <= end_date:
            selected_files.append(files[i])
for temp in selected_files:
    file_dates.append(int(temp[8:16]))

#Time to extract the weather data
timestamps = []
out_temp_list = []
out_humi_list = []
dew_point_list = []
heat_index_list = []
wind_chill_list = []
baro_pressure_list = []
rain_list = []
wind_speed_list = []
wind_average_list = []
wind_peak_list = []
wind_dir_list = []
indo_temp_list = []
indo_humi_list = []
for temp_file_name in selected_files:
    path = "../../weather/data.bak/" + temp_file_name
    temp_file = open(path, "r")
    for line in temp_file.readlines():
        current_line = line.split(",")
        timestamps.append(current_line[0].replace("\r\n", ""))
        out_temp_list.append(current_line[1].replace("\r\n", ""))
        out_humi_list.append(current_line[2].replace("\r\n", ""))
        dew_point_list.append(current_line[3].replace("\r\n", ""))
        heat_index_list.append(current_line[4].replace("\r\n", ""))
        wind_chill_list.append(current_line[5].replace("\r\n", ""))
        baro_pressure_list.append(current_line[6].replace("\r\n", ""))
        rain_list.append(current_line[7].replace("\r\n", ""))
        wind_speed_list.append(current_line[8].replace("\r\n", ""))
        wind_average_list.append(current_line[9].replace("\r\n", ""))
        wind_peak_list.append(current_line[10].replace("\r\n", ""))
        wind_dir_list.append(current_line[11].replace("\r\n", ""))
        indo_temp_list.append(current_line[12].replace("\r\n", ""))
        #indo_humi_list.append(current_line[13].replace("\r\n", ""))
    temp_file.close()

#Need to remove some extra information that was picked up from reading the files
unwanted_strings = ["Timestamp", "Outdoor Temperature", "Outdoor Humidity", "Dew Point", "Heat Index", "Wind Chill", "Barometric Pressure", "Rain", "Wind Speed", "Wind Average", "Peak Wind", "Wind Direction", "Indoor Temperature", "Indoor Humidity"]
out_temp_list = [i for i in out_temp_list if i not in unwanted_strings]
out_humi_list = [i for i in out_humi_list if i not in unwanted_strings]
dew_point_list = [i for i in dew_point_list if i not in unwanted_strings]
heat_index_list = [i for i in heat_index_list if i not in unwanted_strings]
wind_chill_list = [i for i in wind_chill_list if i not in unwanted_strings]
baro_pressure_list = [i for i in baro_pressure_list if i not in unwanted_strings]
rain_list = [i for i in rain_list if i not in unwanted_strings]
wind_speed_list = [i for i in wind_speed_list if i not in unwanted_strings]
wind_average_list = [i for i in wind_average_list if i not in unwanted_strings]
wind_peak_list = [i for i in wind_peak_list if i not in unwanted_strings]
wind_dir_list = [i for i in wind_dir_list if i not in unwanted_strings]

#Need to translate the list of strings into lists of ints
out_temp_list = list(map(float, out_temp_list))
out_humi_list = list(map(float, out_humi_list))
dew_point_list = list(map(float, dew_point_list))
heat_index_list = list(map(float, heat_index_list))
wind_chill_list = list(map(float, wind_chill_list))
baro_pressure_list = list(map(float, baro_pressure_list))
rain_list = list(map(float, rain_list))
wind_speed_list = list(map(float, wind_speed_list))
wind_average_list = list(map(float, wind_average_list))
wind_peak_list = list(map(float, wind_peak_list))
wind_dir_list = list(map(float, wind_dir_list))

#Create the chosen graphs/pngs
if temp_flag == "ON":
    generate_graph(timestamps, out_temp_list, "temperature", "Deg F")
if humidity_flag == "ON":
    generate_graph(timestamps, out_humi_list, "humidity", "%")
if dew_flag == "ON":
    generate_graph(timestamps, dew_point_list, "dew", "Deg F")
if heat_flag == "ON":
    generate_graph(timestamps, heat_index_list, "heat-index", "Deg F")
if wind_chill_flag == "ON":
    generate_graph(timestamps, wind_chill_list, "wind-chill", "Deg F")
if pressure_flag == "ON":
    generate_graph(timestamps, baro_pressure_list, "pressure", "psi")
if rain_flag == "ON":
    generate_graph(timestamps, rain_list, "rain", "inches")
if wind_speed_flag == "ON":
    generate_graph(timestamps, wind_speed_list, "wind-speed", "mph")
if wind_average_flag == "ON":
    generate_graph(timestamps, wind_average_list, "wind-average", "mph")
if wind_peak_flag == "ON":
    generate_graph(timestamps, wind_peak_list, "wind-peak", "mph")
if wind_dir_flag == "ON":
    generate_graph(timestamps, wind_dir_list, "wind-dir", "radial degrees")

xrange_low = timestamps[0]
xrange_high = timestamps[len(timestamps)-1]

print ("Content-type:text/html\r\n\r\n")
print ("<html>")
print ("<head>")
print ("<title>wdi output</title>")
print ("</head>")
print ("<body>")
print ("<P>Plot Temperature: %s</P>" % temp_flag)
print ("<P>Plot Humidity: %s</P>" % humidity_flag)
print ("<P>Plot Dew Point: %s</P>" % dew_flag)
print ("<P>Plot Heat Index: %s</P>" % heat_flag)
print ("<P>Plot Wind Chill: %s</P>" % wind_chill_flag)
print ("<P>Plot Barometric Pressure: %s</P>" % pressure_flag)
print ("<P>Plot Rainfall: %s</P>" % rain_flag)
print ("<P>Plot Wind Speed: %s</P>" % wind_speed_flag)
print ("<P>Plot Wind Average: %s</P>" % wind_average_flag)
print ("<P>Plot Peak Wind: %s</P>" % wind_peak_flag)
print ("<P>Plot Wind Direction: %s</P>" % wind_dir_flag)
print ("<P>Start Date: %s %s %s</P>" % (start_year, start_month, start_day))
print ("<P>End Date: %s %s %s</P>" % (end_year, end_month, end_day))
print ("<P>Xrange low is:%s </P>" % xrange_low)
print ("<P>Xrange high is:%s </P>" % xrange_high)
print ("</body>")

#print the images onto the webpage
print ("<P>")
if temp_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/temperature.png\" alt=\"temp_graph\">")
if humidity_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/humidity.png\" alt=\"humi_graph\">")
print ("</P>")
print ("<P>")
if dew_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/dew.png\" alt=\"dew_graph\">")
if heat_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/heat-index.png\" alt=\"heat-index_graph\">")
print ("</P>")
print ("<P>")
if wind_chill_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/wind-chill.png\" alt=\"wind-chill_graph\">")
if pressure_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/pressure.png\" alt=\"pressure_graph\">")
print ("</P>")
print ("<P>")
if rain_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/rain.png\" alt=\"rain_graph\">")
if wind_speed_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/wind-speed.png\" alt=\"wind-speed_graph\">")
print ("</P>")
print ("<P>")
if wind_average_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/wind-average.png\" alt=\"wind-average_graph\">")
if wind_peak_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/wind-peak.png\" alt=\"wind-peak_graph\">")
print ("</P>")
print ("<P>")
if wind_dir_flag == "ON":
    print ("<img src=\"/~ivan/wdi/wdi_images/wind-dir.png\" alt=\"wind-dir_graph\">")
print ("</P>")

print ("</html>")
