import { useState, useEffect } from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/style2.module.css";

function CitaLibretaMilitar({ setPagina }){
    
    const [cita, setCita] = useState("");

    const idUsuario = sessionStorage.getItem("id_usuario");
    const apiURL = "/tramiteweb/rest/cita/ultimacita";

    useEffect(() => {
        obtenerDatosUsuarioLogueado();
    }, []);

    async function obtenerDatosUsuarioLogueado() {
        const respuesta = await axios.get(apiURL + "/" + idUsuario);
        setCita({
            nombreTramite: respuesta.data.nombre_tramite,
            numeroIdentificacionUsuario: respuesta.data.numero_identificacion_usuario,
            nombresUsuario: respuesta.data.nombres_usuario,
            apellidosUsuario: respuesta.data.apellidos_usuario,
            direccionEntidad: respuesta.data.direccion_entidad,
            fecha: respuesta.data.fecha,
            hora: respuesta.data.hora
        });
    }

    function handleAtrasClick() {
        setPagina("LibretaMilitar");
    }

    function handleInicioClick() {
        setPagina("Menu");
    }

    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>

                <h2 className={styles.h2}>Información de Citación</h2>

                <form autoComplete="off" className={styles.form}>
                    <div className={styles.formGroup}>
                        <label className={styles.label}>
                            Tipo de cita
                            <p className={styles.p}>{cita.nombreTramite}</p>
                        </label>
                        <label className={styles.label}>
                            Numero de identificacion
                            <p className={styles.p}>{cita.numeroIdentificacionUsuario}</p>
                        </label>
                        <label className={styles.label}>
                            Nombres
                            <p className={styles.p}>{cita.nombresUsuario}</p>
                        </label>
                        <label className={styles.label}>
                            Apellidos
                            <p className={styles.p}>{cita.apellidosUsuario}</p>
                        </label>
                        <label className={styles.label}>
                            Direccion de Distrito Militar
                            <p className={styles.p}>{cita.direccionEntidad}</p>
                        </label>
                        <label className={styles.label}>
                            Fecha
                            <p className={styles.p}>{cita.fecha}</p>
                        </label>
                        <label className={styles.label}>
                            Hora
                            <p className={styles.p}>{cita.hora}</p>
                        </label>
                    </div>
                </form>
                <button onClick={handleAtrasClick} className={styles.btn}>Atras</button>
                <button onClick={handleInicioClick} className={styles.btn}>Inicio</button>
            </div>
        </div>
    );
}

export default CitaLibretaMilitar;