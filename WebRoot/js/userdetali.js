  
function start(){   
	MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];   
	
	//先给年下拉框赋内容   	
var year=document.getElementById("year");
for(var i=1970;i<=new Date().getFullYear();i++){
	var option=document.createElement("option");
	option.value=i;
	option.innerText=" "+ i +" 年";
	year.appendChild(option);
	
}	
	//赋月份的下拉框   
	var month=document.getElementById("month");
	for(var i=1;i<=12;i++){
		var option=document.createElement("option");
		option.value=i;
		option.innerText=" "+ i +"月";
		month.appendChild(option);
		
	}
 
	

	
	 

	
}     
if(document.attachEvent)   
	window.attachEvent("onload", start);   
else   
window.addEventListener('load', start, false);   
function yearChange(str) //年发生变化时日期发生变化(主要是判断闰平年)   
{   
 var month = document.getElementById("month").options[document.getElementById("month").selectedIndex].value;
alert(document.getElementById("month").options[document.getElementById("month").selectedIndex].value);   
	if (month == ""){ 
	optionsClear(document.getElementById("day")); 
	return;
	}   
	var n = MonHead[month - 1];   
	if (month ==2 && IsrunYear(str)) n++;   
	writeDay(n)   
}   
function monthChange(str)   //月发生变化时日期联动   
{   
	var YYYYvalue = document.getElementById("year").options[document.getElementById("year").selectedIndex].value;   
	if (YYYYvalue == ""){ var e = document.getElementById("day"); optionsClear(e); return;}   
	var n = MonHead[str - 1];   
	if (str ==2 && IsrunYear(YYYYvalue)) n++;   
	writeDay(n)   
}   
function writeDay(n)   //据条件写日期的下拉框   
{   
	
	var day=document.getElementById("day");
	
	optionsClear(day);   
	for (var i=1; i<=n; i++){
	
	var option=document.createElement("option");
		option.value=i;
		option.innerText=" "+ i +"日";
		day.appendChild(option);
	
	
}
	
	 
}   
function IsrunYear(year)//判断是否闰平年   
{
	return((year%4==0 && (year%100 !=0) || year%400 == 0));
}   
function optionsClear(e)   
{   
	e.options.length = 1;   
}  


function dosubmit(){
	
	makebirth();
	makePreference();
}
function makebirth(){
	
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;
var birth = year + "-" + month + "-" + day;
	
	var input = document.createElement("input");
	input.type="hidden";
	input.name = "birth";
	input.value = birth
	
	document.getElementById("user").appendChild(input);
	
	
}
function makePreference()
{
	var preference = "";
	var pres = document.getElementsByName("pre");
	for(var i=0;i<pres.length;i++)
	{
		if(pres[i].checked==true)
		{
			preference = preference + pres[i].value + ",";
		}
	}
	preference = preference.substr(0,preference.length-1);	
	
	var input = document.createElement("input");
	input.type = "hidden";
	input.name = "preferences";
	input.value=preference;
	
	document.getElementById("user").appendChild(input);
	
}





