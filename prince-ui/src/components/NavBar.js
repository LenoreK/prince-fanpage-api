import { Link } from "react-router-dom";

function NavBar() {
    return (
        <nav className="navbar">
            <h1>Albums</h1>
            <div className="col d-flex justify-content-end">
                <Link to="/add" className="btn btn-primary">Add Album</Link>
            </div>    
        </nav>
    );
}

export default NavBar;