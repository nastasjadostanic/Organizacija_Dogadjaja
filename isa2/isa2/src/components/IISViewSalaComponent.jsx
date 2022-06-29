import React, { Component } from 'react';
import SalaService from '../services/SalaService';

class IISViewSalaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            brojMesta: '',
            tip: '',
            vrstaDogadjaja: ''

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
        this.setState({ modifikacija: event.target.value });
    }
    componentDidMount() {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        if (activeUser.type == "organizator" )
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
                    <input name="nazv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                    <label> Broj mesta: </label>
                    <input name="brojMesta" className="form-control" value={this.state.brojMesta} onChange={this.changeBrojMestaHandler} />
                    <label>Tip: </label>
                    <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler} />
                    <label> Vrsta dogadjaja: </label>
                    <input name="vrstaDogadjaja" className="form-control" value={this.state.vrstaDogadjaja} onChange={this.changeVrstaDogadjajaHandler} />
                    <label> Modifikacija: </label>
                    <input name="modifikacija" className="form-control" value={this.state.modifikacijaSale} onChange={this.changeModifikacijaHandler} />
                    
                    <br />

                   
                      
                </div>
                
            </div>
        );
    }
}

export default IISViewSalaComponent;