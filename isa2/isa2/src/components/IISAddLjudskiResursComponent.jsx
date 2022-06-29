import React, { Component } from 'react';
import axios from 'axios';

class IISAddLjudskiResursComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            vrsta: '',
            brojLjudi: '',
            oblastDelovanja: '',
            brojTelefona: ''
        }

        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeVrstaHandler = this.changeVrstaHandler.bind(this);
        this.changeBrojLjudiHandler = this.changeBrojLjudiHandler.bind(this);
        this.changeOblastDelovanjaHandler = this.changeOblastDelovanjaHandler.bind(this);
        this.changeBrojTelefonaHandler = this.changeBrojTelefonaHandler.bind(this);

    }
    
    changeNazivHandler = (event) => {
        this.setState({ naziv: event.target.value });
    }
    changeCenaHandler = (event) => {
        this.setState({ cena: event.target.value });
    }
    changeVrstaHandler = (event) => {
        this.setState({ vrsta: event.target.value });
    }
    changeBrojLjudiHandler = (event) => {
        this.setState({ brojLjudi: event.target.value });
    }
    changeOblastDelovanjaHandler = (event) => {
        this.setState({ oblastDelovanja: event.target.value });
    }
    changeBrojTelefonaHandler = (event) => {
        this.setState({ brojTelefona: event.target.value });
    }

    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }

    Add() {
        
        let ljudskiresurs = {           
            id:this.state.id,
            naziv:this.state.naziv,
            cena:this.state.cena,
            vrsta:this.state.vrsta,
            brojLjudi:this.state.brojLjudi,
            oblastDelovanja:this.state.oblastDelovanja,
            brojTelefona :this.state.brojTelefona
            
        }
        let activeUser = JSON.parse(localStorage.getItem('activeUser'))
        console.log('ljudskiresurs => ' + JSON.stringify(ljudskiresurs));
        axios.post("http://localhost:8080/api/v1/ljudskiResursi/" +activeUser.type ,ljudskiresurs);
        this.props.history.push(`/ljudskiresursi`);
        window.location.reload();
    }

    componentDidMount() {
        let activeUser = JSON.parse(localStorage.getItem('activeUser'))

        if (activeUser.type != "organizator") { this.logout(); alert("Unauthorised access") }
    }
    render() {
        return (
            <div>
                
                <div className="registrationdiv">
                    <br /><br />
                    <label> Naziv: </label>
                    <input  name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                    <label> Vrsta: </label>
                    <input name="vrsta" className="form-control" value={this.state.vrsta} onChange={this.changeVrstaHandler} />
                    <label> Broj ljudi: </label>
                    <input name="brojLjudi" className="form-control" value={this.state.brojLjudi} onChange={this.changeBrojLjudiHandler} />
                    <label> Oblast delovanja: </label>
                    <input name="oblastDelovanja" className="form-control" value={this.state.oblastDelovanja} onChange={this.changeOblastDelovanjaHandler} />
                    <label> Broj telefona: </label>
                    <input name="brojTelefona" className="form-control" value={this.state.brojTelefona} onChange={this.changeBrojTelefonaHandler} />
                
                    <br />
                    <div className="center"><button className="loginbtn" onClick={()=>this.Add()}>Add</button></div>



                </div>
            </div>

        );
    }
}

export default IISAddLjudskiResursComponent;