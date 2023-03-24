import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Confirmation from "./components/Confirmation";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import Error from "./components/Error";
import Delete from "./components/Delete";
import AlbumForm from "./components/AlbumForm";
import NotFound from "./components/NotFound";
import Album from "./components/Album"
import TopSongs from "./components/TopSongs";

function App() {
  return (
    <Router>

      <Routes>
        <Route path="/add" element={<AlbumForm />} />
        <Route path="/edit:id" element={<AlbumForm />} />
        <Route path="/delete:id" element={<Delete />} />
        <Route path="/confirmation" element={<Confirmation />} />
        <Route path="/error" element={<Error />} />
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NotFound />} />
        <Route path="/Albums" element={<Album />} />
        <Route path="/topSongs" element={<TopSongs />} />
      </Routes>
    </Router>
  )
}

export default App;