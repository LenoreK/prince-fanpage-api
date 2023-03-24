

function Home() {

    const styles = {
        backgroundImage:`url(https://images.unsplash.com/photo-1495576596703-e0063a132b6e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8c3B5fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=800&q=60`,
        backgroundColor: `grey`,
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        height: '100vh',
  };

  window.addEventListener("DOMContentLoaded", event => {
    const audioElement = document.getElementById("audioElement");
    audioElement.play();
  });

    
    return(
    
        <div style={styles}> 
        <nav class="navbar navbar-expand-lg bg-success">
        <div class="container-fluid">
            <h1>Welcome to Prince Fan Page</h1>        
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
                <a class="nav-link" href="/album">Album</a>
                <a class="nav-link" href="/agency">Top Songs</a>
                
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