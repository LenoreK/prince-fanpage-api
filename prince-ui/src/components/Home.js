import { getElementError } from "@testing-library/react";
import {Link} from "react-router-dom";
import { useState } from "react";

function Home() {

    const [isPlaying, setIsPlaying] = useState(false);

    const styles = {
        backgroundImage:`url(https://wallpaper.dog/large/10836890.jpg`,
        backgroundColor: '',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        height: '110vh',
  };

  function Play() {
    const audio = document.getElementById('audioElement');

    if (isPlaying) {
      audio.pause();
      setIsPlaying(false);
    } else {
      audio.play();
      setIsPlaying(true);
    }
  }


    
    return(
    
        <div style={styles}> 
        <nav className="navbar navbar-expand">
        <div className="container-fluid">
            <h1 className="header">Welcome to Prince Fan Page</h1>        
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
              <div class="navbar-nav">

                <a className="nav-link active" aria-current="page" href="/">Home</a>
                <a className="nav-link" href="/albums">Albums</a>
                <a className="nav-link" href="/topSongs">Top Songs</a>
                <button  onClick={Play}>💜</button>

  
              </div>
            </div> 
    
        </div>
        </nav>
        <audio id="audioElement" autoplay>
          <source src="resources/prince.mp3" type="audio/mp3"/>
        </audio>
      </div>
    
  
  );

    
}

export default Home;