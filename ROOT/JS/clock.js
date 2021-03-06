var time = new Date();
var h = time.getHours(); //时
var m = time.getMinutes(); //分
var s = time.getSeconds(); //秒
h=h>12?(h-12)*5+parseInt(m/12):h*5+parseInt(m/12); //时针 初始位置
//=====================================
var x=200,y=200,sAngle=0; //x y 原点 秒针角度变量
 
function draw(){
	showDate();
    var c=document.getElementById("clock");
    var ctx=c.getContext("2d"); //获取绘图对象
    ctx.clearRect(0,0,c.width,c.height); //清除上次绘制的图形
    s++;//秒针
 
    ctx.fillStyle = '#fff' //填充白色背景色 
    ctx.fillRect(0,0,c.width,c.height);   //设置画布区域
 
	//填充圆点，在画布中心（300,200）绘制一个半径10px的圆形
	ctx.beginPath();
	ctx.arc(x,y,10,0,Math.PI*2,true);
	ctx.fill();
	ctx.closePath();

	//调用日期并填充到画布中
	ctx.fillStyle="#666";
	ctx.font = "38pt Verdana";
	ctx.fillText("Time",130,60);
	
	ctx.save(); //保存当前绘图状态
 
    // 时间刻度
    for(var i=0;i<12;i++){
        var angle=(Math.PI*2)/12;
        ctx.beginPath();//开始绘制
		ctx.font="12px Arial";
        if(i==0||i==3||i==6||i==9){
             ctx.fillStyle="red";
             radius=4;
        }else{
             ctx.fillStyle="blue";
             radius=3;
        }
 
        ctx.arc(x,y-100,radius,0,Math.PI*2,true); //画圆
        ctx.fill(); //填充路径
        trans(ctx,x,y,angle);  //刻度分布              
    }
    ctx.restore(); //恢复上次保存的绘图状态
 
    sAngle=(Math.PI*2)/60*s; //秒度
	//时针转动
    ctx.save(); 
    ctx.strokeStyle="red";
    ctx.lineWidth=3;
    trans(ctx,x,y,(Math.PI*2)/60*h); 
    pointer(ctx,x,y,y-40);
    ctx.restore();
 	
	//分针转动
	ctx.save();
	ctx.strokeStyle="blue";
	ctx.lineWidth=2;
	trans(ctx,x,y,(Math.PI*2)/60*m); 
	pointer(ctx,x,y,y-68);
	ctx.restore();
 
	//秒针转动
	ctx.save();
	ctx.strokeStyle="#000";
	trans(ctx,x,y,sAngle);  
	pointer(ctx,x,y,y-80);
	ctx.restore();  
 
    //数据整理
    if(s%60==0){
		sAngle=0,s=0,m++;
        if(m%12==0){ //每十二分 时针旋转一次
            if(m!=0)h++;
            if(m%60==0)m=0;
        }
     	if(h%60==0)h=0; 
    }
}

function showDate(){
	var c=document.getElementById("date");
    var ctx=c.getContext("2d"); //获取绘图对象
    ctx.clearRect(0,0,c.width,c.height); //清除上次绘制的图形
	ctx.fillStyle = '#fff' //填充白色背景色 
    ctx.fillRect(0,0,c.width,c.height);   //设置画布区域
	
	//调用日期并填充到画布中
	var innerWidth = 50;
	var base = 120;
	ctx.fillStyle="#666";
	ctx.font = "40pt Verdana";
	ctx.fillText("Date",50,60);
	ctx.font = "30pt Verdana";
	ctx.fillText(time.getFullYear(),70,base+innerWidth*0);
	ctx.fillText('|',110,base+innerWidth*1);
	var space = time.getMonth < 9 ? "":"0"; 
	ctx.fillText(space+(time.getMonth()+1),90,base+innerWidth*2);
	ctx.fillText('|',110,base+innerWidth*3);
	ctx.fillText(time.getDate(),90,base+innerWidth*4);
	
	ctx.save(); //保存当前绘图状态
}
 
//绘制指针
function pointer(ctx,x,y,z){
     ctx.beginPath();
     ctx.moveTo(x,y);
     ctx.lineTo(x,z);
     ctx.stroke();
     ctx.fill();
}
 
 //据坐标旋转
function trans(ctx,x,y,angle){
     ctx.transform(Math.cos(angle), Math.sin(angle), 
        -Math.sin(angle), Math.cos(angle), 
        x*(1-Math.cos(angle)) + x*Math.sin(angle), 
      	y*(1-Math.cos(angle)) - y*Math.sin(angle))
}
 
setInterval("draw()",1000);
