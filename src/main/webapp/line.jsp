<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Day Vs Temperature</title>
</head>
<body>
	<button>Get Chart</button>

	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	<script>
	$(document).ready(function(){
    $("button").click(function(){
    	$.ajax({url: "http://localhost:8080/RESTfulExample/rest/tabletemp/Temp", 
        	success: function(result){
        		console.log(result);
        		var seriesData = [];
        		var tmpData = [];
        		for(i=0;i<result.length;i++){
        			console.log(result[i].day);
        			tmpData = [
        						Date.UTC(new Date(result[i].day).getFullYear(),
        								new Date(result[i].day).getMonth(),
        								new Date(result[i].day).getDate()
        								),
        						result[i].temperature
        					]
        			seriesData.push(tmpData);
        		}
        		console.log(seriesData);
        	
			Highcharts.chart('container', {
   						 chart: {
   							zoomType: 'x'
   						 },
   						 title: {
     						    text: 'Day vs Temperature'
    					 },
   						 xAxis: {
   							type: 'datetime',
   							 dateTimeLabelFormats: {
   								millisecond: '%H:%M:%S.%L',
   								second: '%H:%M:%S',
   								minute: '%H:%M',
   								hour: '%H:%M',
   								day: '%e. %b %Y'
   					         }
    					 },			
   						 yAxis: {
       							 title: {
            							text: 'Temperature (�C)'
        						 }
    					 },
    								 tooltip: {
    				        		        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
    				        		        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
    				        		            '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
    				        		        footerFormat: '</table>',
    				        		        shared: true,
    				        		        useHTML: true
    				        		  },
    				        		    plotOptions: {
    				        		    	 area: {
    				        		                fillColor: {
    				        		                    linearGradient: {
    				        		                        x1: 0,
    				        		                        y1: 0,
    				        		                        x2: 0,
    				        		                        y2: 1
    				        		                     },
    				        		                    stops: [
    				        		                        [0, Highcharts.getOptions().colors[0]],
    				        		                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
    				        		                    ]
    				        		                  },
    				        		                marker: {
    				        		                    radius: 2
    				        		                },
    				        		                lineWidth: 1,
    				        		                states: {
    				        		                    hover: {
    				        		                        lineWidth: 1
    				        		                    }
    				        		                },
    				        		                threshold: null
    				        		            },
    				        		    },
    					series:[{
    			            type: 'area',
    			            name: 'Date',
    			            data: seriesData
    			        }] 
    						
											


			 });
        							},
			error : function (a,b,c){
				console.log(a,b,c);
			}						
				
	});
	});
	});
   </script>
</body>
</html>