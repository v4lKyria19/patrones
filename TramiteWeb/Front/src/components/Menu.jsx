import { useState, useEffect } from "react";
import { instance as axios } from "../api/axios";
import styles from "../styles/styless.module.css";

function Menu({ setPagina }) {

    const [nombreUsuario, setNombreUsuario] = useState("Usuario");

    const idUsuario = sessionStorage.getItem("id_usuario");
    const apiURL = "/tramiteweb/rest/usuario";

    useEffect(() => {
        obtenerDatosUsuarioLogueado();
    }, []);

    async function obtenerDatosUsuarioLogueado() {
        const response = await axios.get(apiURL + "/" + idUsuario);
        setNombreUsuario(response.data.nombres + " " + response.data.apellidos);
    }

    function handleRegistraduriaClick() {
        setPagina("Registraduria");
    }

    function handleLibretaClick() {
        setPagina("LibretaMilitar");
    }

    function handleHistorialClick() {
        setPagina("Historial");
    }

    function handleCerrarSesionClick(){
        sessionStorage.removeItem("id_usuario");
        alert("Sesion cerrada.");
        setPagina("Index");
    }

    return (
        <div className={styles.body}>
            <nav className={styles.menu}>
                <section className={styles.menuContainer}>
                    <ul className={styles.menuLinks}>
                        <li className={styles.menuItemMenuItemShow}>
                            <a className={styles.menuLink}>Agendamiento de citas <img src="/arrow.svg" className={styles.menuArrow} /></a>
                            <ul className={styles.menuNesting}>
                                <li className={styles.menuInside}>
                                    <a onClick={handleRegistraduriaClick} className={styles.menuLinkMenuLinkInside}>Registraduria Nacional</a>
                                </li>
                                <li className={styles.menuInside}>
                                    <a onClick={handleLibretaClick} className={styles.menuLinkMenuLinkInside}>Libreta Militar</a>
                                </li>
                            </ul>
                        </li>
                        <li className={styles.menuItem}>
                            <a onClick={handleHistorialClick} className={styles.menuLink}>Consultar citas pendientes</a>
                        </li>
                        <li className={styles.menuItem}>
                            <a onClick={handleCerrarSesionClick} className={styles.menuLink}>Cerrar sesion</a>
                        </li>
                    </ul>
                    <div className={styles.menuHamburguer}>
                        <img src="/menu.svg" className={styles.menuImg} />
                    </div>
                    <h1 className={styles.username}>{nombreUsuario}</h1>
                </section>
            </nav>
            <header className={styles.header}>
                <div className={styles.headerContentContainer}>
                        <div className={styles.content}>
                            <h1 className={styles.h1}>TRAMITEWEB</h1>
                            <p className={styles.p}>
                                Portal web de asignamiento y consulta de citas referentes a procesos de documentación con entidades del estado colombiano. 
                            </p>
                        </div>
                        <img src="/img-1.svg" alt="" className={styles.headerContentImg} />
                </div>
            </header>
            <main className={styles.servicesContainer}>
                <div className={styles.service}>
                    <img src="/se1.png" alt="" className={styles.img} />
                    <h3 className={styles.h3}>Agendamiento de citas</h3>
                    <p className={styles.p}>
                        Selecciona la entidad con la que necesitas agilizar un proceso referente
                        a documentación y completa la información necesaria.

                    </p>
                </div>
                <div className={styles.service}>
                    <img src="/se2.png" alt="" className={styles.img} />
                    <h3 className={styles.h3}>Colaboración con entidades Nacionales</h3>
                    <p className={styles.p}>
                        A través de la colaboración con las entidades del estado buscamos facilitar
                        la adquisición de documentos a los ciudadanos colombianos.
                    </p>
                </div>
                <div className={styles.service}>
                    <img src="/se3.png" alt="" className={styles.img}/>
                    <h3 className={styles.h3}>Historial de citas agendadas</h3>
                    <p className={styles.p}>
                        Visualización y seguimiento de citas pendientes con las entidades del estado colombiano 
                        con su respectiva información.
                    </p>
                </div>
            </main>
            <footer className={styles.footer}>
                <div className={styles.container}>
                    <div className={styles.enlaces}>
                        <h3 className={styles.h3}><img src="/logo2.png" width="170" height="100" className={styles.img} /></h3>
                    </div>
                    <p className={styles.p}>
                        Somos una entidad privada que busca dinamizar las relaciones entre la ciudadania y el Estado,
                        gracias al uso y aplicación de herramientas tecnológicas 
                        en las plataformas que desarrollamos.
                    </p>
                </div>
            </footer>
        </div>
    );
}

export default Menu;