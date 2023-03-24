import { Link } from "react-router-dom";

function NavBar() {
    return (
        <nav className="navbar">
            <h1 class="header"> Albums</h1>
                <Link className="nav-link link" to="/">Home</Link>
                <Link className="nav-link link" to="/Albums">Albums</Link>
                <Link className="nav-link link" to="/TopSongs">Top Songs</Link>
            <div className="col d-flex justify-content-end">
                <Link to="/add" className="btn btn-primary add">Add Album</Link>
            </div>    
        </nav>
    );
}

export default NavBar;