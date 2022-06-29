import axios from 'axios';
import React, { Component } from 'react';
import SalaService from '../services/SalaService';

class IISGostViewSalaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            brojMesta: '',
            tip: '',
            vrstaDogadjaja: '',
            modifikacijaSale: ''

        }
        
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeBrojMestaHandler = this.changeBrojMestaHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeVrstaDogadjajaHandler = this.changeVrstaDogadjajaHandler.bind(this);
        this.changeModifikacijaHandler = this.changeModifikacijaHandler.bind(this);
        
    }
    

    changeNazivHandler = (event) => {
        this.setState({ naziv: event.target.value });
    }
    changeCenaHandler = (event) => {
        this.setState({ cena: event.target.value });
    }
    changeBrojMestaHandler = (event) => {
        this.setState({ brojMesta: event.target.value });
    }
    changeTipHandler = (event) => {
        this.setState({ tip: event.target.value });
    }
    changeVrstaDogadjajaHandler = (event) => {
        this.setState({ vrstaDogadjaja: event.target.value });
    }
    changeModifikacijaHandler = (event) => {
        this.setState({ modifikacijaSale: event.target.value });
    }

    zahtevZaModifikaciju(modifikacijaSale){
        //dodavanje zahteva za modifikaciju
        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'));
        let activeUser=  JSON.parse(localStorage.getItem('activeUser'));

        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        today = yyyy + '-' + mm + '-' + dd;

        let zahtev = {
            datumZahteva: today,
            opisZahteva: modifikacijaSale,
            dogadjajID : activeDogadjaj.id,
            gostId: activeUser.id
        }
            console.log(zahtev);
        //kreiranje
        axios.post("http://localhost:8080/api/v1/zahteviModifikacije/gost/" , zahtev);

    }
    componentDidMount() {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        if (activeUser.type == "gost" )
        {
        let activeSala =  JSON.parse(localStorage.getItem('activeSala'));
        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'));
        this.setState({
            id:activeSala.id,
            naziv:activeSala.naziv,
            cena:activeSala.cena,
            brojMesta:activeSala.brojMesta,
            tip:activeSala.tip,
            vrstaDogadjaja:activeSala.vrstaDogadjaja,
            modifikacijaSale: activeDogadjaj.modifikacijaSale
        });
    } 
    else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                <h2 className='text-center'>Sala</h2>
                
                <div style={{position:'absolute',top:'100px',left:'35%'}} className="registrationdiv">
                    <br /><br />
                    <label> Naziv: </label>
                    <input name="nazv" className="form-control" value={this.state.naziv} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena}/>
                    <label> Broj mesta: </label>
                    <input name="brojMesta" className="form-control" value={this.state.brojMesta} />
                    <label>Tip: </label>
                    <input name="tip" className="form-control" value={this.state.tip}  />
                    <label> Vrsta dogadjaja: </label>
                    <input name="vrstaDogadjaja" className="form-control" value={this.state.vrstaDogadjaja} />
                    <label> Modifikacija: </label>
                    <input name="modifikacija" className="form-control" value={this.state.modifikacijaSale} onChange={this.changeModifikacijaHandler} />
                    
                    <br />

                   
                    <div className="center"><button className="loginbtn" onClick={()=>this.zahtevZaModifikaciju(this.state.modifikacijaSale)}>Zahtevaj</button></div>
                       
                </div>
                
            </div>
        );
    }
}

export default IISGostViewSalaComponent;