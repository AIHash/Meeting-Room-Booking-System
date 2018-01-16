<!DOCTYPE html>
<html>

<head>

   <head>
        <title>Pick a room</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
</head>
<body>
     <div id="nav-placeholder"></div>
    <script>
$(function(){
  $("#nav-placeholder").load("header.html");
});
</script>
    
<h3><font color="red">${errorMessage}</font></h3>
<form method="post">
    <table border="1">
        <tbody>
            <tr>
                <td>Room</td>
                <td>
                    <select name="room_id">
                        <option value="1">1.1</option>
                        <option value="2">1.2</option>
                        <option value="3">1.3</option>
                        <option value="4">1.4</option>
                        <option value="5">1.5</option>
                        <option value="6">1.6</option>
                        <option value="7">1.7</option>
                        <option value="8">1.8</option>
                        <option value="9">1.9</option>
                        <option value="10">1.10</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Start Date</td>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td>Day</td>
                <td><input type="text" name="start_day" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Month</td>
                <td><input type="text" name="start_month" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Year</td>
                <td><input type="text" name="start_year" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Hour</td>
                <td><input type="text" name="start_hour" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Min</td>
                <td><input type="text" name="start_minute" value="" /></td>
            </tr>
            <tr>
                <td>End Date</td>
                <td></td>
            </tr>
            <tr>
                <td></td>
                <td>Day</td>
                <td><input type="text" name="end_day" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Month</td>
                <td><input type="text" name="end_month" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Year</td>
                <td><input type="text" name="end_year" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Hour</td>
                <td><input type="text" name="end_hour" value="" /></td>
            </tr>
            <tr>
                <td></td>
                <td>Min</td>
                <td><input type="text" name="end_minute" value="" /></td>
            </tr>
        </tbody>
    </table>
    <button type="submit" >Submit</button>
</form>
</body>
</html>
<style type="text/css">
    form{
       margin-left: 20%;

    }



</style>