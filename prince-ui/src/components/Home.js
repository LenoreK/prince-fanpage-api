
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
            <h1>Welcome to Prince Fan Page</h1>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="/">Home</a>
                <a class="nav-link" href="/album">Albums</a>
                <a class="nav-link" href="/agency">Top Songs</a>
                
              </div>
            </div> 
    
        </div>
        </nav>
      </div>
    
        
        
       
  
  );

    
}

export default Home;