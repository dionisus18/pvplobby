  $(document).ready(function(){
    $('.tabs').tabs();
    $('.modal').modal();
    $('.datepicker').datepicker({ selectMonths: true, // Creates a dropdown to control month
    selectYears: 15, // Creates a dropdown of 15 years to control year
    format: 'dd-mm-yyyy' });
    $('textarea#txtCuerpo').characterCounter();
    $('.timepicker').timepicker({twelveHour: false});
  });