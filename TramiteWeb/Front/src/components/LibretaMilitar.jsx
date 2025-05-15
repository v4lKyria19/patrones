import { useState, useEffect } from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/style2.module.css";

function LibretaMilitar({ setPagina }){
    
    const [usuario, setUsuario] = useState("");

    const idUsuario = sessionStorage.getItem("id_usuario");
    const apiUsuarioURL = "/tramiteweb/rest/usuario";
    const apiUsuarioTramiteURL = "/tramiteweb/rest/usuariotramite";

    useEffect(() => {
        obtenerDatosUsuarioLogueado();
    }, []);

    async function obtenerDatosUsuarioLogueado() {
        const respuesta = await axios.get(apiUsuarioURL + "/" + idUsuario);
        setUsuario({
            numeroIdentificacion: respuesta.data.numero_identificacion,
            nombres: respuesta.data.nombres,
            apellidos: respuesta.data.apellidos
        });
    }

    async function añadirRegistroUsuarioTramite(idUsuario, idTramite) {
        const respuesta = await axios.post(
            apiUsuarioTramiteURL,
            {
                "id_usuario": idUsuario,
                "id_tramite": idTramite
            },
            {
                headers: {
                "Content-Type": "application/json",
                },
            }
        );

        return respuesta;
    }

    function handleAtrasClick() {
        setPagina("Menu");
    }

    function handleSubmit(e) {
        e.preventDefault();
        const form = e.target;
        const formData = new FormData(form);
        const formJson = Object.fromEntries(formData.entries());

        const idTramite = formJson.cita;

        añadirRegistroUsuarioTramite(idUsuario, idTramite);
        setPagina("CitaLibretaMilitar");
    }

    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>
                <h2 className={styles.h2}>Libreta Militar</h2>
                <p className={styles.p2}>Ingrese sus datos personales</p>
                <form autoComplete="off" onSubmit={handleSubmit} className={styles.form}>
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>
                            <label htmlFor="cita" className={styles.label}>Solicitar cita para</label>
                            <select name="cita" className={styles.select}>
                                <option value="4" className={styles.option}>Presentar documentacion</option>
                                <option value="5" className={styles.option}>Reclamar libreta militar</option>
                            </select>
                        </div>
                        <div className={styles.formContent}>        
                            <label htmlFor="NumeroIdentificacion" className={styles.label}>Numero de Identificacion</label>
                            <input type="text" id="identificacion" name="identificacion" value={usuario.numeroIdentificacion} readOnly className={styles.input} /><br />
                        </div>
                    </div> 
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>   
                            <label htmlFor="Name" className={styles.label}>Nombres</label>
                            <input type="text" id="name" name="name" value={usuario.nombres} readOnly className={styles.input} /><br />
                        </div>
                        <div className={styles.formContent}> 
                            <label htmlFor="apellidos" className={styles.label}>Apellidos</label>
                            <input type="text" id="apellidos" name="apellidos" value={usuario.apellidos} readOnly className={styles.input} /><br />
                        </div>
                    </div>    
                    <button type="submit" className={styles.btn}>Continuar</button>
                    <button onClick={handleAtrasClick} className={styles.btn}>Atras</button>
                </form>
            </div>
        </div>
    );
}

export default LibretaMilitar;