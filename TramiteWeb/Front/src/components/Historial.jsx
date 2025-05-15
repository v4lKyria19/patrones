import { useState, useEffect } from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/stylesh.module.css";

function Historial({ setPagina }) {

    const [listaTramites, setListaTramites] = useState(null);

    const idUsuario = sessionStorage.getItem("id_usuario");
    const apiURL = "/tramiteweb/rest/usuariotramite";
    let tramites = listaTramites && listaTramites.map && listaTramites.map(tramite => {
        return (
            <tr key={tramite.contador_registro} className={styles.tr}>
                <td className={styles.td}>{tramite.nombre_entidad}</td>
                <td className={styles.td}>{tramite.nombre_tramite}</td>
                <td className={styles.td}>{tramite.fecha_registro}</td>
            </tr>
        );
    });;

    useEffect(() => {
        obtenerDatosUsuarioLogueado();
    }, []);

    async function obtenerDatosUsuarioLogueado() {
        const response = await axios.get(apiURL + "/" + idUsuario);
        setListaTramites(response.data);
    }  

    function handleAtrasClick(){
        setPagina("Menu");
    }

    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>
                <h2 className={styles.h2}>Historial de tramites</h2>
                <div className={styles.container}>
                    <table className={styles.table}>
                        <thead className={styles.thead}> 
                            <tr className={styles.tr}>
                                <th className={styles.th}>Entidad</th>
                                <th className={styles.th}>Tramite</th>
                                <th className={styles.th}>Fecha de registro</th>
                            </tr>

                        </thead>
                        <tbody className={styles.tbody}>
                            {tramites}
                        </tbody>
                    </table>
                </div>
                <a onClick={handleAtrasClick} className={styles.btn1}>Atras</a>
            </div>
        </div>
    );
}

export default Historial;