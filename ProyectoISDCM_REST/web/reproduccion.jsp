<%-- 
    Document   : reproduccion
    Created on : 02-may-2018, 11:07:48
    Author     : Beñat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <<link rel="stylesheet" href="css/style_video.css" type="text/css"/>
        <link rel="stylesheet" href="js/bootstrap.min.css" type="text/css"/>
    </head>
  <body>
      
       <!-- <div id="divframe">
<!-- 1. The <iframe> (and video player) will replace this <div> tag. -->
        <div style="float:left; padding:10px 10px 10px 10px; margin:0 !important;" id="player"></div> 
     
        <script>



          // 2. This code loads the IFrame Player API code asynchronously.
          var tag = document.createElement('script');

          tag.src = "https://www.youtube.com/iframe_api";
          var firstScriptTag = document.getElementsByTagName('script')[0];
          firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
            var mivideo="${idVideo}";
          // 3. This function creates an <iframe> (and YouTube player)
          //    after the API code downloads.
          var player;
            function onYouTubeIframeAPIReady() {
                    player = new YT.Player('player', {
                            padding:'150px',
                            height: '360',
                            width: '640',
                            videoId: mivideo,
                            events: {
                              'onReady': onPlayerReady,
                              'onStateChange': onPlayerStateChange
                            }
                    });
            }
          // 4. The API will call this function when the video player is ready.
          function onPlayerReady(event) {
            event.target.playVideo();
          }

          // 5. The API calls this function when the player's state changes.
          //    The function indicates that when playing a video (state=1),
          //    the player should play for six seconds and then stop.
          var done = false;
          function onPlayerStateChange(event) {
            if (event.data == YT.PlayerState.PLAYING && !done) {
              setTimeout(stopVideo, 6000);
              done = true;
            }
          }
          function stopVideo() {
            player.stopVideo();
          }
        </script>
        </div>
        <div class="col-sm-7">
            </br></br></br>
            <div class="col-sm-3">
                <p><b>Titulo:</b> ${videoReproduccion.titulo}</p>
                <p><b>Año Publicación:</b> ${videoReproduccion.apubli}</p>
                
            </div>
                
            <div class="col-sm-3">
                <p><b>Duracion:</b> ${videoReproduccion.duracion}</p>
                <p><b>Numero reproducciones:</b> ${videoReproduccion.reproduccion}</p>
                <br>
            </div>  
                
            <div class="col-sm-3">   
                <p><b>Url:</b> ${videoReproduccion.url}</p>
                <br>
            </div>   
                </br>  </br>  </br>  </br>  </br>
                <center><div class="formRepro"> 
                <form action="servletRegistroVid" method="post">
                <input type="submit" name="actualizar" value="Regresar">
                </form>
                    </div></center>
        <!--</div>   --> 

  </body>
</html>
