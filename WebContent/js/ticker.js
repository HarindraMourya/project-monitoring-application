
/*
Typing Scroller
Submitted by bengaliboy00@hotmail.com (hp: http://www.angelfire.com/nt/bengaliboy/)
With modifications by Dynamicdrive.com
For full source code, usage terms, and 100s more scripts, visit http://dynamicdrive.com
*/

//Secify scroller contents
var line=new Array();
line[1]="Delivering Latest Course Content as per Industry"
line[2]="100% Satisfaction Guaranteed."
line[3]="360 degree Assessment."
line[4]="1000+ Practical Assignments."
line[5]="1000+ Interview questions."
line[6]="Training Provided by Industry Experienced Faculties."
line[7]="Project Implementation as per Industry Guidelines and Standards."
line[8]="Provide Software Domain and Technical Knowledge"
line[9]="Provide Real time Software Enviornment."
line[10]="We don't promise job, we make you worthy of it."
line[11]="Certification Preparation Classes."
line[12]="Online Training Material Avaliable."
//Specify font size for scoller
var ts_fontsize="15pt"

//--Don't edit below this line

var longestmessage=1
for (i=2;i<line.length;i++){
if (line[i].length>line[longestmessage].length)
longestmessage=i
}

//Auto set scroller width
var tscroller_width=line[longestmessage].length

lines=line.length-1 //--Number of lines

//if IE 4+ or NS6
if (document.all||document.getElementById){
document.write('<form name="bannerform">')
document.write('<input type="text" name="banner" size="'+tscroller_width+'"')
document.write('style="background-color:transparent; text-align:left; width:658px;'+document.bgColor+'; color:#424242  '+document.body.text+'; font-family:impact, Georgia;  font-size:'+ts_fontsize+'; font-weight:normal; border: medium none" onfocus="blur()">')
document.write('</form>')
}

temp=""
nextchar=-1;
nextline=1;
cursor="\\"
function animate(){
if (temp==line[nextline] & temp.length==line[nextline].length & nextline!=lines){
nextline++;
nextchar=-1;
document.bannerform.banner.value=temp;
temp="";
setTimeout("nextstep()",2000)}
else if (nextline==lines & temp==line[nextline] & temp.length==line[nextline].length){
nextline=1;
nextchar=-1;
document.bannerform.banner.value=temp;
temp="";
setTimeout("nextstep()",2000)}
else{
nextstep()}}

function nextstep(){

if (cursor=="\\"){
cursor="|"}
else if (cursor=="|"){
cursor="/"}
else if (cursor=="/"){
cursor="-"}
else if (cursor=="-"){
cursor="\\"}


nextchar++;
temp+=line[nextline].charAt(nextchar);
document.bannerform.banner.value=temp+cursor
setTimeout("animate()",50)}

//if IE 4+ or NS6
if (document.all||document.getElementById)
window.onload=animate
// -->