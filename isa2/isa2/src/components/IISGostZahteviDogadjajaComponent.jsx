import axios from 'axios';
import React, { Component } from 'react';
import ZahteviZaPrivatneService from '../services/ZahteviZaPrivatneService';

class IISGostZahteviDogadjajaComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           zahtevi: []

        }
       
        this.vidiLjudski = this.vidiLjudski.bind(this);
        this.vidiOstali = this.vidiOstali.bind(this);
        this.vidiSalu = this.vidiSalu.bind(this);
    }

  vidiLjudski(id) {
    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
    axios
    .get("http://localhost:8080/api/v1/ljudskiResursi/id/gost/" + id)
    .then(response => {
        localStorage.setItem('activeResurs',JSON.stringify(response.data));
        this.props.history.push(`/vidiljudski`);
    });

}
vidiOstali(id) {
    let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
    axios
    .get("http://localhost:8080/api/v1/ostaliResursi/id/gost/" + id)
    .then(response => {
        localStorage.setItem('activeResurs',JSON.stringify(response.data));
        this.props.history.push(`/vidiostali`);
    });

}
vidiSalu(id){

}
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" ){
        
           axios.get("http://localhost:8080/api/v1/zahteviPrivatanDogadjaj/gostId/gost/" + activeUser.id).then((res) => {
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

export default IISGostZahteviDogadjajaComponent;