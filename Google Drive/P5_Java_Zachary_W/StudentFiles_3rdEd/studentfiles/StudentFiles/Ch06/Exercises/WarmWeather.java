// Chapter 6 Question 16

boolean warm;
if(location.isNorthPole() || location.isSouthPole())
{warm = false;} else if(location.isTropics()) {warm
= true;} else if (time.getMonth()==4 || time.getMonth()==10)
{if (weather.isSunny()) {warm = true;}else{warm = false;}}
else if (location.isNorthernHemisphere()) {if(time.getMonth()
>=5 && time.getMonth() <= 9) {warm=true;} else{warm=false;}}
else if(location.isSouthernHemisphere()){if(time.getMonth()
>= 11 ||time.getMonth()<= 3) {warm = true;} else{warm=
false;}} else{warm = false;}


