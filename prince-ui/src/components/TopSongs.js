import NavBar from "./NavBar";
function TopSongs() {
    return (
    <>
        <NavBar />
        <div id="song-body">
        <h1 id="top-songs">Top Rated Songs</h1>
        <ul id="grid" class="list-group">
            <li class="list-group-item">Purple Rain</li>
            <li class="list-group-item">When Doves Cry</li>
            <li class="list-group-item">Kiss</li>
            <li class="list-group-item">Raspberry Beret</li>
            <li class="list-group-item">1999</li>
            <li class="list-group-item">Little Red Corvette</li>
            <li class="list-group-item">Let's Go Crazy</li>
            <li class="list-group-item">Sign O' The Times</li>
            <li class="list-group-item">I Wanna Be Your Lover</li>
            <li class="list-group-item">If I Was Your Girlfirend</li>
            </ul>
            </div>
    </>
    );
}
export default TopSongs;