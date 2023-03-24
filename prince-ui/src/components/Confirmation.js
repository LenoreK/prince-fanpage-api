import { useLocation } from "react-router-dom";
import { Link } from "react-router-dom";

function Confirmation() {
    const location = useLocation();

    return (
        <>
            <p>Album Info Saved {location.state ? location.state.msg : "☑️"} </p>
            <Link to="/">Return</Link>
        </>
    )
}

export default Confirmation;