import axios from 'axios';
import React, { Component } from 'react';
import ZahteviZaPrivatneService from '../services/ZahteviZaPrivatneService';

class ZahtevZaPrivatneComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
        //this.viewDogadjaj = this.viewDogadjaj.bind(this);
        this.delete = this.delete.bind(this);
        this.vidiLjudski = this.vidiLjudski.bind(this);
        this.vidiOstali = this.vidiOstali.bind(this);
        this.prihvati = this.prihvati.bind(this);
    }
    
    delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj/" +activeUser.type + "/" + id);
        window.location.reload();
    }
  prihvati(id){

    //KREIRANJE DOGADJAJA

    /*
    dogadjaj <= zahtevzadogadaj

    datumNaplate <=datumOdrzavanja
    salaId <= brojMesta i vrsta
    tip <= vrsta
    ukupnaCena <= ljudskiResursiId (cena) + ostaliResursiId (cena)
    */
 
    axios
    .get("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj/organizator/" + id)
    .then(response => {
        localStorage.setItem('activeZahtevZaPrivatan',JSON.stringify(response.data));
    });
    let activeZahtevZaPrivatan =  JSON.parse(localStorage.getItem('activeZahtevZaPrivatan'));

    
    axios
        .get("http://localhost:8080/api/v1/ljudskiResursi/id/organizator/" + activeZahtevZaPrivatan.ljudskiResursId)
        .then(response => {
            localStorage.setItem('activeLjudski',JSON.stringify(response.data));
        });
        let activeLjudski =  JSON.parse(localStorage.getItem('activeLjudski'));

    axios
        .get("http://localhost:8080/api/v1/ostaliResursi/id/organizator/" + activeZahtevZaPrivatan.ostaliResursId)
        .then(response => {
            localStorage.setItem('activeOstali',JSON.stringify(response.data));
        });
        let activeOstali =  JSON.parse(localStorage.getItem('activeOstali'));
   
   
   var sala = null; 
   var ukupna = activeLjudski.cena +  activeOstali.cena; 
    
    if(activeZahtevZaPrivatan.vrsta=="Vencanje"){
        if(activeZahtevZaPrivatan.brojMesta<=100){
            sala=1;
            ukupna = ukupna + 200;
        }
        else if(activeZahtevZaPrivatan.brojMesta>100 & activeZahtevZaPrivatan.brojMesta<=200){
            sala=2;
            ukupna = ukupna + 400;
        }
        else if(activeZahtevZaPrivatan.brojMesta<=300) {
            sala=4;
            ukupna = ukupna + 450;
        }
        else {alert("Nije moguce organizovati dogadjaj ni u jednoj od sala")}
    }
    else if(activeZahtevZaPrivatan.vrsta=="Konferencija"){
        if(activeZahtevZaPrivatan.brojMesta<=100) {
            sala = 3;
            ukupna = ukupna + 100;
        }
        else if(activeZahtevZaPrivatan.brojMesta<=300) { 
            sala=4;
            ukupna = ukupna + 450;
        }
        else {alert("Nije moguce organizovati dogadjaj ni u jednoj od sala")}
    }
    else {
        if(activeZahtevZaPrivatan.brojMesta<=300){
            sala =4;
            ukupna = ukupna + 450;
        }
        else {alert("Nije moguce organizovati dogadjaj ni u jednoj od sala")}
    }
    
    if(sala!=null)
    {
        let dogadjaj = {
            ukupnaCena: ukupna,
            datumNaplate: activeZahtevZaPrivatan.datumOdrzavanja,
            datumOdrzavanja: activeZahtevZaPrivatan.datumOdrzavanja,
            vremeOdrzavanja: activeZahtevZaPrivatan.vremeOdrzavanja,
            trajanje: activeZahtevZaPrivatan.trajanje,
            tip:activeZahtevZaPrivatan.vrsta,
            salaID: sala
        }

        axios.post("http://localhost:8080/api/v1/dogadjaji", dogadjaj );
    }
    else {alert("Nije moguce organizovati dogadjaj")}

    //brisanje zahteva

    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios.delete("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj/" +activeUser.type + "/" + activeZahtevZaPrivatan.id);
        window.location.reload();
  }

  vidiLjudski(id) {
    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
    axios
    .get("http://localhost:8080/api/v1/ljudskiResursi/id/organizator/" + id)
    .then(response => {
        localStorage.setItem('activeResurs',JSON.stringify(response.data));
        this.props.history.push(`/vidiljudski`);
    });

}
vidiOstali(id) {
    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
    axios
    .get("http://localhost:8080/api/v1/ostaliResursi/id/organizator/" + id)
    .then(response => {
        localStorage.setItem('activeOstaliResurs',JSON.stringify(response.data));
        this.props.history.push(`/vidiostali`);
    });

}
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj").then((res) => {
                this.setState({ zahtevi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                

                <h2 style={{position:'absolute',top:'100px',left:'35%'}} className="text-center">Zahtevi za privatne dogadjaje </h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                
                                
                                <th>Datum odrzavanja</th>
                                <th>Vreme odrzavanja</th>
                                <th>Vrsta</th>
                                <th>Trajanje</th>
                                <th>Broj mesta</th>
                                <th>Ljudski resurs</th>
                                <th>Ostali resurs</th>
                                
                                <th>Akcija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.zahtevi.map(
                                    zahtevi =>
                                        <tr key={zahtevi.id}>
                                            
                                            <td>{zahtevi.datumOdrzavanja}</td>
                                            <td>{zahtevi.vremeOdrzavanja}</td>
                                            <td>{zahtevi.vrsta}</td>
                                            <td>{zahtevi.trajanje}</td>
                                            <td>{zahtevi.brojMesta}</td>
                                            <td><button onClick={() => this.vidiLjudski(zahtevi.ljudskiResursId)} className="loginbtn">Vidi</button></td>
                                            <td><button onClick={() => this.vidiOstali(zahtevi.ostaliResursId)} className="loginbtn">Vidi</button></td>
                                            

                                                <td>
                                                    <button onClick={() => this.prihvati(zahtevi.id)} className="loginbtn">Prihvati</button>
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

export default ZahtevZaPrivatneComponent;