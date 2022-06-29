
import axios from 'axios';
import React, { Component } from 'react';


class IISGostZahtevLjudskiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            vrsta: '',
            brojLjudi: '',
            oblastDelovanja: '',
            brojTelefona:'',
            dogadjajID:'',
            resursID:''

        }
        
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeVrstaHandler = this.changeVrstaHandler.bind(this);
        this.changeBrojLjudiHandler = this.changeBrojLjudiHandler.bind(this);
        this.changeOblastDelovanjaHandler = this.changeOblastDelovanjaHandler.bind(this);
        this.changeBrojTelefonaHandler = this.changeBrojTelefonaHandler.bind(this);
        this.changeDogadjajIdHandler = this.changeDogadjajIdHandler.bind(this);
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
    
    changeDogadjajIdHandler = (event) => {
        this.setState({ dogadjajID: event.target.value });}
    
    
    posalji(dogadjajid){
        let activeResurs = JSON.parse(localStorage.getItem('activeResurs'));
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        //kreira se zahtev za resurs sa tipom ljudski, datumom kada je kreiran
        
        //datum
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        today = yyyy + '-' + mm + '-' + dd;

        let zahtev = {
            datumZahteva: today,
            tipResursa: "Ljudski",
            resursID: activeResurs.id,
            gostId: activeUser.id, 
            dogadjajID: dogadjajid
        }


        axios.post("http://localhost:8080/api/v1/zahteviresursa/gost", zahtev);

        
    }

    componentDidMount() {
        //let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'))
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" )
        {
        let activeLjudskiResurs =  JSON.parse(localStorage.getItem('activeResurs'));
        this.setState({
            id:activeLjudskiResurs.id,
            naziv:activeLjudskiResurs.naziv,
            cena:activeLjudskiResurs.cena,
            vrsta:activeLjudskiResurs.vrsta,
            brojLjudi:activeLjudskiResurs.brojLjudi,
            oblastDelovanja:activeLjudskiResurs.oblastDelovanja,
            brojTelefona:activeLjudskiResurs.brojTelefona,
            resursID:activeLjudskiResurs.resursID
        });
    } 
    else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                <h2 className='text-center'>Ljudski resurs</h2>
                
                <div style={{position:'absolute',top:'100px',left:'35%'}} className="registrationdiv">
                    <br /><br />
                    <label> Naziv: </label>
                    <input name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                    <label> Vrsta: </label>
                    <input name="vrsta" className="form-control" value={this.state.vrsta} onChange={this.changeVrstaHandler} />
                    <label>Broj ljudi: </label>
                    <input name="brojLjudi" className="form-control" value={this.state.brojLjudi} onChange={this.changeBrojLjudiHandler} />
                    <label> Oblast delovanja: </label>
                    <input name="oblastDelovanja" className="form-control" value={this.state.oblastDelovanja} onChange={this.changeOblastDelovanjaHandler} />
                    <label> Broj telefona: </label>
                    <input name="brojTelefona" className="form-control" value={this.state.brojTelefona} onChange={this.changeBrojTelefonaHandler} />
                    <label> Dogadjaj id: </label>
                    <input name="dogadjajId" className="form-control" value={this.state.dogadjajID} onChange={this.changeDogadjajIdHandler} />
                    
                    <br />
                    <button onClick={() => this.posalji(this.state.dogadjajID)} className="loginbtn">Posalji</button>

                </div>
                
            </div>
        );
    }
}

export default IISGostZahtevLjudskiComponent;