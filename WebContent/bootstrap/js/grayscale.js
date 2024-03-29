/*!
 * Start Bootstrap - Grayscale Bootstrap Theme (http://startbootstrap.com)
 * Code licensed under the Apache License v2.0.
 * For details, see http://www.apache.org/licenses/LICENSE-2.0.
 */

// jQuery to collapse the navbar on scroll
function collapseNavbar() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
}

$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);

// jQuery for page scrolling feature - requires jQuery Easing plugin
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});

// Closes the Responsive Menu on Menu Item Click
$('.navbar-collapse ul li a').click(function() {
  if ($(this).attr('class') != 'dropdown-toggle active' && $(this).attr('class') != 'dropdown-toggle') {
    $('.navbar-toggle:visible').click();
  }
});

// Google Maps Scripts
var map = null;
// When the window has finished loading create our google map below
google.maps.event.addDomListener(window, 'load', init);
google.maps.event.addDomListener(window, 'resize', function() {
    map.setCenter(new google.maps.LatLng(60.996064, 24.464132));
});

function init() {
    // Basic options for a simple Google Map
    // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
    var mapOptions = {
        // How zoomed in you want the map to start at (always required)
        zoom: 14,

        // The latitude and longitude to center the map (always required)
        center: new google.maps.LatLng(60.996064, 24.464132), // Hämeenlinna Sibeluiksenkatu 7

        // Disables the default Google Maps UI components
        disableDefaultUI: true,
        scrollwheel: false,
        draggable: false,

        // How you would like to style the map. 
        // This is where you would paste any style found on Snazzy Maps.
        styles: [
                 {
                     "featureType": "all",
                     "elementType": "labels.text.fill",
                     "stylers": [
                         {
                             "saturation": 36
                         },
                         {
                             "color": "#120d19"
                         }
                     ]
                 },
                 {
                     "featureType": "all",
                     "elementType": "labels.text.stroke",
                     "stylers": [
                         {
                             "visibility": "on"
                         },
                         {
                             "color": "#ffffff"
                         },
                         {
                             "lightness": 16
                         }
                     ]
                 },
                 {
                     "featureType": "all",
                     "elementType": "labels.icon",
                     "stylers": [
                         {
                             "visibility": "off"
                         }
                     ]
                 },
                 {
                     "featureType": "administrative",
                     "elementType": "geometry.fill",
                     "stylers": [
                         {
                             "color": "#fefefe"
                         },
                         {
                             "lightness": 20
                         }
                     ]
                 },
                 {
                     "featureType": "administrative",
                     "elementType": "geometry.stroke",
                     "stylers": [
                         {
                             "color": "#fefefe"
                         },
                         {
                             "lightness": 17
                         },
                         {
                             "weight": 1.2
                         }
                     ]
                 },
                 {
                     "featureType": "landscape",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#efefef"
                         }
                     ]
                 },
                 {
                     "featureType": "poi",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#f5f5f5"
                         },
                         {
                             "lightness": 21
                         }
                     ]
                 },
                 {
                     "featureType": "poi.park",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#dedede"
                         },
                         {
                             "lightness": 21
                         }
                     ]
                 },
                 {
                     "featureType": "road.highway",
                     "elementType": "geometry.fill",
                     "stylers": [
                         {
                             "color": "#7a7a7a"
                         }
                     ]
                 },
                 {
                     "featureType": "road.highway",
                     "elementType": "geometry.stroke",
                     "stylers": [
                         {
                             "color": "#ffffff"
                         },
                         {
                             "lightness": 29
                         },
                         {
                             "weight": 0.2
                         }
                     ]
                 },
                 {
                     "featureType": "road.arterial",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#7a7a7a"
                         },
                         {
                             "lightness": 25
                         }
                     ]
                 },
                 {
                     "featureType": "road.local",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#7a7a7a"
                         },
                         {
                             "lightness": 70
                         }
                     ]
                 },
                 {
                     "featureType": "transit",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#f2f2f2"
                         },
                         {
                             "lightness": 19
                         }
                     ]
                 },
                 {
                     "featureType": "water",
                     "elementType": "geometry",
                     "stylers": [
                         {
                             "color": "#353535"
                         }
                     ]
                 }
             ]
    };

    // Get the HTML DOM element that will contain your map 
    // We are using a div with id="map" seen below in the <body>
    var mapElement = document.getElementById('map');

    // Create the Google Map using out element and options defined above
    map = new google.maps.Map(mapElement, mapOptions);

    // Custom Map Marker Icon - Customize the map-marker.png file to customize your icon
    var image = 'bootstrap/img/map-marker-red-small.png';
    var myLatLng = new google.maps.LatLng(60.996064, 24.464132);
    var beachMarker = new google.maps.Marker({
        position: myLatLng,
        map: map,
        icon: image
        
        
    });
    
    
        
    
}
