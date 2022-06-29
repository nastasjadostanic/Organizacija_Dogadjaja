import React, { Component } from 'react';
import { Navbar, Nav, NavDropdown } from 'react-bootstrap';
import { Container } from 'react-bootstrap';
const navLinkStyle = {
    color: 'black'
}

class GostHeaderComponent extends Component {


    render() {
        return (
           
                 <div>
                <Navbar>
                    <Container>
                        
                        <Navbar.Brand style={navLinkStyle} >ORGANIZACIJA DOGADJAJA</Navbar.Brand>
                        <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                        <Navbar.Collapse id="responsive-navbar-nav">                            
                            <Nav className="container-fluid">
                                <Nav.Link style={navLinkStyle} href="/gostprofil">Profil</Nav.Link>
                                <Nav.Link style={navLinkStyle} eventKey={2} href="/gostdogadjaji">Moji dogadjaji</Nav.Link>
                                <Nav.Link style={navLinkStyle} eventKey={3} href="/gostsale">Sale</Nav.Link>
                                <NavDropdown title="Resursi" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/gostljudskiresursi">Ljudski</NavDropdown.Item>
                                    <NavDropdown.Item href="/gostostaliresursi">Ostali</NavDropdown.Item>                       
                                </NavDropdown> 
                                <NavDropdown title="Zahtevi" id="basic-nav-dropdown">
                                    <NavDropdown.Item href="/gostzahtevidogadjaja">Za privatne dogadjaje</NavDropdown.Item>
                                    <NavDropdown.Item href="/gostzahtevimodifikacije">Za modifikacije sale</NavDropdown.Item>
                                    <NavDropdown.Item href="/gostzahteviresursa">Za koriscenje resursa</NavDropdown.Item>
                                </NavDropdown>  
                                  
                                <Nav.Item><Nav.Link style={navLinkStyle} href="/login" onClick={()=>localStorage.removeItem('activeUser')}>Odjavi se</Nav.Link></Nav.Item>
                            </Nav>
                        </Navbar.Collapse>
                    </Container>
                </Navbar>
            </div> 
           
        );
    }
}

export default GostHeaderComponent;

