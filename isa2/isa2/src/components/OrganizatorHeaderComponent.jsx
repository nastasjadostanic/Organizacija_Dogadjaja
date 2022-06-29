import React, { Component } from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { Container } from 'react-bootstrap';
const navLinkStyle = {
    color: 'black'
}

class OrganizatorHeaderComponent extends Component {


    render() {
        return (
           
                 <div>
                <Navbar>
                    <Container>
                        
                        <Navbar.Brand style={navLinkStyle} >ORGANIZACIJA DOGADJAJA</Navbar.Brand>
                        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                        <Navbar.Collapse id="responsive-navbar-nav">                            
                            <Nav className="container-fluid">
                                <Nav.Link style={navLinkStyle} href="/organizatorprofil">Profil</Nav.Link>
                                <Nav.Link style={navLinkStyle} eventKey={2} href="/dogadjaji">Dogadjaji</Nav.Link>
                                
                                <NavDropdown title="Resursi" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/ljudskiresursi">Ljudski</NavDropdown.Item>
                                    <NavDropdown.Item href="/ostaliresursi">Ostali</NavDropdown.Item>                       
                                </NavDropdown> 
                                <NavDropdown title="Zahtevi" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/zahteviprivatni">Za privatne dogadjaje</NavDropdown.Item>
                                    <NavDropdown.Item href="/zahtevimodifikacije">Za modifikacije sale</NavDropdown.Item>
                                    <NavDropdown.Item href="/zahteviresursa">Za koriscenje resursa</NavDropdown.Item>
                                </NavDropdown>  
                                  
                                <Nav.Item classsname="ms-auto"><Nav.Link style={navLinkStyle} href="/" onClick={()=>localStorage.removeItem('activeUser')}>Odjavi se</Nav.Link></Nav.Item>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div> 
           
        );
    }
}

export default OrganizatorHeaderComponent;

