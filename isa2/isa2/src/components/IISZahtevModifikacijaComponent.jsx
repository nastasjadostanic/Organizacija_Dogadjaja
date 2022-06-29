import axios from 'axios';
import React, { Component } from 'react';
//import ZahteviZaModifikacijuService from '../services/ZahteviZaModifikacijuService';

class ZahtevModifikacijaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
        //this.viewDogadjaj = this.viewDogadjaj.bind(this);
        this.delete = this.delete.bind(this);
        this.prihvati = this.prihvati.bind(this);
    }
    
    delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviModifikacije/" +activeUser.type + "/" + id);
        window.location.reload();
    }
    prihvati(dogadjajID, opis, zahtevID){
    //treba updatovati dogadjaj i setovati njegovo polje modifikacijaSale na opis iz zahteva

    //uzizmanje dogadjaja koji zelimo da updatujemo 
    axios.get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajID).then(response => {
        localStorage.setItem('trenutniDogadjaj',JSON.stringify(response.data));
    });
    let trenutniDogadjaj = JSON.parse(localStorage.getItem('trenutniDogadjaj'));
    
    

    //U trenutni treba staviti modifikaciju koja je zapravo opis u zahtevu
    let trenutniDogadjaj2 = { 
        //id: trenutniDogadjaj.id,
        ukupnaCena: trenutniDogadjaj.ukupnaCena,
        datumNaplate: trenutniDogadjaj.datumNaplate,
        datumOdrzavanja: trenutniDogadjaj.datumOdrzavanja,
        vremeOdrzavanja:trenutniDogadjaj.vremeOdrzavanja,
        trajanje: trenutniDogadjaj.trajanje,
        tip: trenutniDogadjaj.tip,
        salaID: trenutniDogadjaj.salaID,

        modifikacijaSale:opis

    }
    //update dogadjaja da ima modifikaciju
    axios.put("http://localhost:8080/api/v1/dogadjaji/organizator/" + dogadjajID, trenutniDogadjaj2);

    //brisanje iz zahteva

    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviModifikacije/" +activeUser.type + "/" + zahtevID);
        window.location.reload();
  }
    vidiDogadjaj(dogadjajId){
        axios
        .get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajId)
        .then(response => {
            localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
            this.props.history.push(`/vididogadjaj`);
        });
    }
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviModifikacije").then((res) => {
                this.setState({ zahtevi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                

                <h2 style={{position:'absolute',top:'100px',left:'35%'}} className="text-center">Zahtevi za modifikaciju sale </h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                
                                
                                <th>Datum zahteva</th>
                                <th>Opis zahteva</th>
                                <th>Dogadjaj</th>
                                
                                <th>Akcija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.zahtevi.map(
                                    zahtevi =>
                                        <tr key={zahtevi.id}>
                                            
                                            <td>{zahtevi.datumZahteva}</td>
                                            <td>{zahtevi.opisZahteva}</td>
                                             
                                            <td><button onClick={() => this.vidiDogadjaj(zahtevi.dogadjajID)} className="loginbtn">Vidi</button></td>

                                                <td>
                                                    <button onClick={() => this.prihvati(zahtevi.dogadjajID, zahtevi.opisZahteva, zahtevi.id)} className="loginbtn">Prihvati</button>
                                                    <button onClick={() => this.delete(zahtevi.id)} className="loginbtn">Odbij</button>
                                                </td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ZahtevModifikacijaComponent;