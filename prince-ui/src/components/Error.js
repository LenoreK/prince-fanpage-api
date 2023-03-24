import { useLocation } from "react-router-dom";

function Error() {
    const location = useLocation();

    return <p>⛔ Error {location.state && location.state.msg}</p>;
}

export default Error;