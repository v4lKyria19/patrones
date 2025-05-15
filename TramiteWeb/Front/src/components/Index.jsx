import styles from "../styles/style.module.css";

function Index({ setPagina }){
    
    function handleIniciarSesionClick(){
        setPagina("InicioSesion");
    }

    function handleRegistrarClick() {
        setPagina("Registro");
    }

    return(
        <div className={styles.body}>
            <header className={styles.header}> 
                <div className={styles.menuContainer}>
                    <a className={styles.logo}></a>
                    <input type="checkbox" id="menu" className={styles.input} />
                    <label htmlFor="menu" className={styles.menuLabel}>
                        <img src="/menu-btn.png" alt="" className={styles.menuIcono} />
                    </label>
                    <nav className={styles.navbar}>
                        <ul className={styles.ul}>
                            <li className={styles.li}>
                                <a onClick={handleIniciarSesionClick} className={styles.a}>Iniciar sesión</a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div className={styles.headerContentContainer}>
                        <div className={styles.content}>
                            <h1 className={styles.h1}>TRAMITEWEB</h1>
                            <p className={styles.p}>
                                Portal Web de asignamiento y consulta de citas referentes a procesos de documentación con entidades del estado colombiano. 
                            </p>
                            <a onClick={handleRegistrarClick} className={styles.btn1}>Registarme</a>
                        </div>
                        <img src="/img-1.svg" alt="" className={styles.img} />
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
                    <img src="/se3.png" alt="" className={styles.img} />
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

export default Index;