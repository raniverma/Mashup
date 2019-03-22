/* JS Goes Here */
var splitobj = String.splitobj(["#one", "#two", "#three"], {  
    elementStyle: function (dimension, size, gutterSize) {
        $(window).trigger('resize'); // Optional
        return { 'flex-basis': 'calc(' + size + '% - ' + gutterSize + 'px)' };
    },
    gutterStyle: function (dimension, gutterSize) { return { 'flex-basis': gutterSize + 'px' }; },
    sizes: [20, 60, 20],
    minSize: 50,
    gutterSize: 6,
    cursor: 'col-resize'
});