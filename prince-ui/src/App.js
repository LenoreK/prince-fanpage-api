import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Confirmation from "./components/Confirmation";

function App() {
  return (
    <Router>
      <NavBar />

      <Routes>
      <Route path="/add" element={<AlbumForm />} />
      <Route path="/edit:id" element={<AlbumForm />} />
      <Route path="/delete:id" element={<Delete />} />
      <Route path="/confirmation" element={<Confirmation />} />
      <Route path="/error" element={<Error />} />
      <Route path="/" element={<Home />} />
      <Route path="*" element={<NotFound />} />
      </Routes>
    </Router>
  )
}

export default App;