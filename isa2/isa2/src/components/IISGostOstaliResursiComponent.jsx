import axios from 'axios';
import React, { Component } from 'react';
import OstaliResursiService from '../services/OstaliResursiService';

class IISGostOstaliResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ostaliresursi: []

        }
        this.zahtevZaKoriscenje = this.zahtevZaKoriscenje.bind(this);
       
       
    }
    zahtevZaKoriscenje(resursId){
        //ucitava activeResurs i otvara stranicu za kreiranje sa popunjenim poljima vezanim za resurs a dodaje polje za dogadjaj id 
        axios
        .get("http://localhost:8080/api/v1/ostaliResursi/id/gost/" + resursId)
        .then(response => {
            localStorage.setItem('activeResurs',JSON.stringify(response.data));
            this.props.history.push(`/gostzahtevostaliresurs`);
        });
    }
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost"){
        
           axios.get("http://localhost:8080/api/v1/ostaliResursi").then((res) => {
                this.setState({ ostaliresursi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

    
    render() {
        return (
            <div>
                
                <h2 style={{position:'absolute',top:'100px',left:'45%'}} className="text-center">Ostali resursi</h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                <th>Naziv</th>
                                <th>Cena</th>
                                <th>Tip</th>
                                <th>Boja</th>
                                <th>Stil</th>
                                <th>Kolicina</th>
                                
                                <th>Akcija</th>
                    
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.ostaliresursi.map(
                                    ostaliresursi =>
                                        <tr key={ostaliresursi.id}>
                                            <td>{ostaliresursi.naziv} </td>
                                            <td>{ostaliresursi.cena}</td>
                                            <td>{ostaliresursi.tip}</td>
                                            <td>{ostaliresursi.boja}</td>
                                            <td>{ostaliresursi.stil}</td>
                                            <td>{ostaliresursi.kolicina}</td>

                                                <td>
                                                    <button onClick={() => this.zahtevZaKoriscenje(ostaliresursi.id)} className="loginbtn">Zahtevaj</button>
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

export default IISGostOstaliResursiComponent;