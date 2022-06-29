import axios from 'axios';
import React, { Component } from 'react';
import DogadjajService from '../services/DogadjajService';

class GostSaleComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           sale: []

        }
        
        //this.addZahtev = this.addZahtev.bind(this);
        
    }

    addZahtev(salaId){

        //uzeli salu i staviti u local i onda otvoriti formu za kreiranje dogadjaja a nju popuniti sa idsale da se organizuje u toj sali
        axios
        .get("http://localhost:8080/api/v1/sale/sala/" + salaId)
        .then(response => {
            localStorage.setItem('activeSala',JSON.stringify(response.data));
            this.props.history.push(`/gostorganizujdogadjaj`);
        });
    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" ){
        
           axios.get("http://localhost:8080/api/v1/sale").then((res) => {
                this.setState({ sale: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

   
    render() {
        return (
            <div>
            
                <h2 style={{position:'absolute',top:'100px',left:'45%'}} className="text-center">Sale</h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                <th>Naziv</th>
                                <th>Cena</th>
                                <th>Broj mesta</th>
                                <th>Tip</th>
                                <th>Vrsta dogadjaja</th>
                                
                                <th>Akcija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.sale.map(
                                    sale =>
                                        <tr key={sale.id}>
                                            <td>{sale.naziv} </td>
                                            <td>{sale.cena}</td>
                                            <td>{sale.brojMesta}</td>
                                            <td>{sale.tip}</td>
                                            <td>{sale.vrstaDogadjaja}</td>
                                            

                                                <td><button onClick={() => this.addZahtev(sale.id)} className="loginbtn">Zahtevaj</button></td>
                                                
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

export default GostSaleComponent;