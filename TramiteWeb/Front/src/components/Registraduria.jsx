import { useState, useEffect } from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/style1.module.css";

function Registraduria({ setPagina }) {
    
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

        const idTramite = formJson.documento;

        añadirRegistroUsuarioTramite(idUsuario, idTramite);
        setPagina("CitaRegistraduria");
    }

    return (
        <div className={styles.body}>
            <div className={styles.formContainer}>

                <h2 className={styles.h2}>Registraduría Nacional del Estado Civil</h2>
                <p className={styles.p}>Ingrese sus datos personales</p>

                <form autoComplete="off" onSubmit={handleSubmit} className={styles.form}>
                    <div className={styles.formGroup}>
                        <div className={styles.formContent}>
                            <label htmlFor="documento" className={styles.label}>Tipo de documento a tramitar</label>
                            <select name="documento" className={styles.select}>
                                <option value="1" className={styles.option}>Tarjeta de Identidad</option>
                                <option value="2" className={styles.option}>Cédula de ciudadanía</option>
                                <option value="3" className={styles.pption}>Pasaporte</option>
                            </select>
                        </div>
                        <div className={styles.formContent}>        
                            <label htmlFor="NumeroIdentificacion" className={styles.label}>Numero de identificacion</label>
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

export default Registraduria;