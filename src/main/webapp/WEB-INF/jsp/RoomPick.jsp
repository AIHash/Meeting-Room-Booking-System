<!DOCTYPE html>
<html>
<style>
* {
    box-sizing: border-box;
}


.header {
    text-align: center;
    padding: 320px;
}
img {
    float: left;
    margin-right: 10px;
    clear:both;
    float: center;
}
h1 {
    margin-left: 0px;
    display:block;

}
#div1 {
    display: inline-block;
      align-items: center;
      float: left;
}

#div2 {
    display: inline-block;
      align-items: center;
      float: left;
}
#div3 {
    display: inline-block;
      align-items: center;
      float: left;
}
/* Create four equal columns that floats next to each other */
.column {
    float: left;
    width: 25%;
    padding: 10px;
}

.column img {
    margin-top: 12px;
}

/* Clear floats after the columns */
.row:after {
    content: "";
    display: table;
    clear: both;
}
#sel11{
     
    display: inline-block;

   width:  70px;
}
h3{
        display: inline-block;

}
#datep{
    display: inline-block;
    margin-left : 3px;
          align-items: center;
}
label{
    display: inline-block;
    float: left;
    text-align: right;
}
input {
  display: inline-block;
  float: left;
}

</style>
<head>
  <script src="https://code.jquery.com/jquery-1.10.2.js"></script> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="utf-8">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="~/Scripts/jquery-1.10.2.min.js"></script>
<script src="~/Scripts/bootstrap.min.js"></script>   <!-- Bootstrap v3.3.5 -->
<script src="~/Scripts/moment.js"></script>
<link rel="stylesheet" type="text/css" href="dist/bootstrap-clockpicker.min.css">
<script src="https://cdn.rawgit.com/atatanasov/gijgo/master/dist/combined/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://cdn.rawgit.com/atatanasov/gijgo/master/dist/combined/css/gijgo.min.css" rel="stylesheet" type="text/css" />

<script src="~/Scripts/bootstrap-datetimepicker.min.js"></script>
<script src="~/Scripts/Core.js"></script>

</head>
<body>
    <div id="nav-placeholder"></div>
    <script>
$(function(){
  $("#nav-placeholder").load("header.html");
});
</script>

 <div id='div1' ><canvas id="mycanvas" width="640" height="500" style="border:4px solid #000000; margin-left:5%;">
    Oops! This browser does not support the HTML5 canvas tag.
</canvas>
</div>

<div class="container">
    <form class="form-horizontal" action="/action_page.php"><!--  ddddddddddddddddddddddddddddd   -->
     
      <div id="div2">
      <h3><label for="sel1"> Select Room</label></h3>
      <select class="form-control" id="sel11">
        <option>1.1</option>
        <option>1.2</option>
        <option>1.3</option>
        <option>1.4</option>
        <option>1.5</option>
        <option>1.6</option>
        <option>1.7</option>
        <option>1.8</option>
        <option>1.9</option>
        <option>1.10</option>
      </select>
  </br>
    <!--date and time picker-->
    <h3><label>Select a date </label></h3>
 <div  id = "datep" class="form-group"> <!-- Date input -->
        <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
      </div>



      <script>

    $(document).ready(function(){
      var date_input=$('input[name="date"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
</script>
</br>
<h3><label>Select a start time </label></h3>

    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
    

   </div>
  </form>

</div>

</body>
<script >



rects = [];
rect = null;
    
//draw room rectangles and numbers over the canvas 
var c = document.getElementById("mycanvas");
var ctx = c.getContext("2d");
var ctxWrt = c.getContext("2d");
var rects ;
ctxWrt.font = "20px Arial";
rect = ctx.rect(20, 20, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.1",80,70);
rect =ctx.rect(20, 190, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.2",230,70);
rect =ctx.rect(20, 290, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.3",380,70);
rect =ctx.rect(20, 390, 300, 100);
rects.push( rect );
ctxWrt.fillText("1.4",530,70);
rect =ctx.rect(170, 20, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.5",80,245);
rect =ctx.rect(320, 20, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.7",80,345);
rect =ctx.rect(470, 20, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.9",160,445);
rect =ctx.rect(470, 190, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.10",460,445);
rect =ctx.rect(470, 290, 150, 100);
rects.push( rect );
ctxWrt.fillText("1.6",530,245);
rect =ctx.rect(320, 390, 300, 100);
rects.push( rect );
ctxWrt.fillText("1.8",530,345);
ctx.stroke();
ctx.closePath();
$('.timepicker').wickedpicker();
 $(function () {
   var bindDatePicker = function() {
        $(".date").datetimepicker({
        format:'YYYY-MM-DD',
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                up: "fa fa-arrow-up",
                down: "fa fa-arrow-down"
            }
        }).find('input:first').on("blur",function () {
            // check if the date is correct. We can accept dd-mm-yyyy and yyyy-mm-dd.
            // update the format if it's yyyy-mm-dd
            var date = parseDate($(this).val());

            if (! isValidDate(date)) {
                //create date based on momentjs (we have that)
                date = moment().format('YYYY-MM-DD');
            }

            $(this).val(date);
        });
    }
   
   var isValidDate = function(value, format) {
        format = format || false;
        // lets parse the date to the best of our knowledge
        if (format) {
            value = parseDate(value);
        }

        var timestamp = Date.parse(value);

        return isNaN(timestamp) == false;
   }
   
   var parseDate = function(value) {
        var m = value.match(/^(\d{1,2})(\/|-)?(\d{1,2})(\/|-)?(\d{4})$/);
        if (m)
            value = m[5] + '-' + ("00" + m[3]).slice(-2) + '-' + ("00" + m[1]).slice(-2);

        return value;
   }
   
   bindDatePicker();
 });

</script> 
</html>
