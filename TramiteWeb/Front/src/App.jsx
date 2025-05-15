import { useState } from "react";
import Index from "./components/Index";
import InicioSesion from "./components/InicioSesion";
import Registro from "./components/Registro";
import Menu from "./components/Menu"
import Historial from "./components/Historial"
import Registraduria from "./components/Registraduria";
import LibretaMilitar from "./components/LibretaMilitar";
import CitaRegistraduria from "./components/CitaRegistraduria";
import CitaLibretaMilitar from "./components/CitaLibretaMilitar";

function App() {
  
  const [pagina, setPagina] = useState("Index");
  
  if (pagina === "Index"){
  	return <Index setPagina={setPagina} />
  } else if (pagina === "InicioSesion"){
    return <InicioSesion setPagina={setPagina} />
  } else if (pagina === "Registro") {
    return <Registro setPagina={setPagina} />
  } else if (pagina === "Menu") {
    return <Menu setPagina={setPagina} />
  } else if (pagina === "Historial") {
    return <Historial setPagina={setPagina} />
  } else if (pagina === "Registraduria") {
    return <Registraduria setPagina={setPagina} />
  } else if (pagina === "LibretaMilitar") {
    return <LibretaMilitar setPagina={setPagina} />
  } else if (pagina === "CitaRegistraduria") {
    return <CitaRegistraduria setPagina={setPagina} />
  } else if (pagina === "CitaLibretaMilitar") {
    return <CitaLibretaMilitar setPagina={setPagina} />
  }

}

export default App;
