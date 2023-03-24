import { getElementError } from "@testing-library/react";
import {Link} from "react-router-dom";

function Home() {

    const styles = {
        backgroundImage:`url(https://wallpaper.dog/large/10836890.jpg`,
        backgroundColor: '',
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        height: '110vh',
  };

    
    return(
    
        <div style={styles}> 
        <nav class="navbar navbar-expand">
        <div class="container-fluid">
            <h1 class="header">Welcome to Prince Fan Page</h1>        
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active link" aria-current="page" href="/">Home</a>
                <a class="nav-link link" href="/albums">Albums</a>

                <a class="nav-link link" href="/topSongs">Top Songs</a>
  
              </div>
            </div> 
    
        </div>
        </nav>
        <audio id="audioElement" autoplay loop controls>
          <source src="resources/prince.mp3" type="audio/mp3"/>
        </audio>
      </div>
    
  
  );

    
}

export default Home;