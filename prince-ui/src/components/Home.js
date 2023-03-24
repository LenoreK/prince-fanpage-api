
function Home() {

    const styles = {
        

    };

    const [albums, setAlbums] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        findAll()
            .then(setAlbums)
            .catch(error => navigate("/error", { state: { msg: error } }))
    }, [navigate]);

    return albums.map((album) => (
        <Album key={album.albumId} album={album} />
    ))
}

export default Home;