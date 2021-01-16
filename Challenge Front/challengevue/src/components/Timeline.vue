<template>
    <div>
        <head>
            <title>Timeline</title>
            <!-- note: moment.js must be loaded before vis.js, else vis.js uses its embedded version of moment.js -->
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/vis/4.18.0/vis.min.css">
            <link rel="stylesheet" type="text/css" href="css/style.css">
            <link rel="stylesheet" type="text/css" href="css/full-style.css">
            <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        </head>

        <body>
            <h3>
                <b>Timeline</b>
            </h3>
            <div id="visualization">
                <div class="menu">
                    <input style="display:none;" id="sliderZoom" type="range" class="range" name="a" min="-1" max="1" step="0.1"
                        value="0" />
                    <i class="material-icons dp48 buttons-menu" id="fit">home</i>
                    <i class="material-icons dp48 buttons-menu" id="moveLeft">arrow_back</i>
                    <i class="material-icons dp48 buttons-menu" id="moveRight">arrow_forward</i>
                </div>
            </div>

        </body>
    </div>
</template>

<script>
    import moment from 'moment';
    import vis from '../../node_modules/vis';

export default {
    mounted: function (){
        var container = document.getElementById("visualization");
var items = new vis.DataSet([
  {
    id: 1,
    content: "Reserva 1",
    start: "2019-03-1 10:00",
    end: "2019-03-1 10:30"
  },
  {
    id: 2,
    content: "Reserva 2",
    start: "2019-03-1 11:00",
    end: "2019-03-1 11:45"
  }
]);
var options = {
  //stack: false,
  orientation: {
    axis: "top",
    item: "top"
  },
  //zoomMax: 31536000000, // just one year
  zoomMax: 87600900, // 10,000 years is maximum possible
  zoomMin: 10000000 // 10ms
};
var timeline = new vis.Timeline(container, items, options);

/**
     * Move the timeline a given percentage to left or right
     * @param {Number} percentage   For example 0.1 (left) or -0.1 (right)
     */
function move(percentage) {
  var range = timeline.getWindow();
  var interval = range.end - range.start;
  timeline.setWindow({
    start: range.start.valueOf() - interval * percentage,
    end: range.end.valueOf() - interval * percentage
  });
}

// attach events to the navigation buttons
document.getElementById("moveLeft").onclick = function() {
  move(0.2);
};
document.getElementById("moveRight").onclick = function() {
  move(-0.2);
};

// Using slider to zoomIn or zoomOut
document.getElementById("sliderZoom").addEventListener("input", function(e) {
    console.log(e)
  var value = this.value;
  if (value < 0) {
    var start = moment().year(moment().year() - 100000), // to adjust with options
      end = moment().year(moment().year() + 1);
    timeline.zoomOut(-value);
    if (value === "-1") timeline.setWindow(start, end);
  } else if (value > 0) {
    start = moment(), end = moment(moment().utc() + 10);
    timeline.zoomIn(value);
    if (value === "1") timeline.setWindow(start, end);
  } else {
    timeline.fit(items.getIds());
    this.value = 0;
  }
});

// To reset zoom initial state
document.getElementById("fit").onclick = function() {
  //$('.range').next().text('0'); // set default if to use output with input range
  document.getElementById("sliderZoom").value = 0;
  timeline.fit(items.getIds());
};
    }
}
</script>