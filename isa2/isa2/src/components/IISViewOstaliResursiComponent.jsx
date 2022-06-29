import axios from 'axios';
import React, { Component } from 'react';
import OstaliResursiService from '../services/OstaliResursiService';


class OstaliResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ostaliresursi: []

        }
        
        this.obrisi = this.obrisi.bind(this);
    }
    obrisi(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        OstaliResursiService.deleteOstaliResurs(id,activeUser.type).then(res => {
            this.setState({ ostaliresursi: this.state.ostaliresursi.filter(ostaliresurs => ostaliresurs.id !== id) });
             
        });
        window.location.refresh();
    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'));
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/ostaliResursi/dogadjaj/" + activeUser.type + "/" + activeDogadjaj.id ).then((res) => {
                this.setState({ ostaliresursi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

    render() {
        return (
            <div>       
                <br />
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
                            { this.state.ostaliresursi.map(
                                   ostaliresursi =>
                                        <tr key={ostaliresursi.id}>
                                            <td>{ostaliresursi.naziv} </td>
                                            <td>{ostaliresursi.cena}</td>
                                            <td>{ostaliresursi.tip}</td>
                                            <td>{ostaliresursi.boja}</td>
                                            <td>{ostaliresursi.stil}</td>
                                            <td>{ostaliresursi.kolicina}</td>

                                                <td><button onClick={() => this.obrisi(ostaliresursi.id)} className="loginbtn">Obrisi</button></td>
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

export default OstaliResursiComponent;