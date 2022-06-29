import axios from 'axios';
import React, { Component } from 'react';
import OstaliResursiService from '../services/OstaliResursiService';

class IISOstaliResursiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           ostaliresursi: []

        }
        this.addOstaliResurs = this.addOstaliResurs.bind(this);
        //this.viewDogadjaj = this.viewDogadjaj.bind(this);
        this.delete = this.delete.bind(this);
    }
    /*delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        LjudskiResursiService.deleteLjudskiResurs(id,activeUser.type).then(res => {
            this.setState({ ljudskiresursi: this.state.ljudskiresursi.filter(ljudskiresurs => ljudskiresurs.id !== id) });
             
        });
        window.location.refresh();
    }*/
    
    addOstaliResurs() {
        this.props.history.push("/dodajostaliresurs");
    }
    
    delete(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));

        axios.delete("http://localhost:8080/api/v1/ostaliResursi/"  + activeUser.type + "/" + id);
        window.location.reload();
    }
    update(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios
            .get("http://localhost:8080/api/v1/ostaliResursi/id/organizator/"  + id)
            .then(response => {
                localStorage.setItem('activeOstaliResurs', JSON.stringify(response.data));
                this.props.history.push(`/izmenaostalihresursa`);
            });


    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator"){
        
           axios.get("http://localhost:8080/api/v1/ostaliResursi").then((res) => {
                this.setState({ ostaliresursi: res.data });
           });
        } 
        else{this.logout(); alert("Unauthorised access")} 
    }

    changeSearchHandler = (event) => {
        this.setState({ search: event.target.value });
        

    }
    render() {
        return (
            <div>
                <button style={{position:'absolute', top:'150px', left:'1480px'}} onClick={() => this.addOstaliResurs(this.props.match.params.id)} className="loginbtn">Add</button>
       
                

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
                                                    <button onClick={() => this.update(ostaliresursi.id)} className="loginbtn">Izmeni</button>
                                                    <button onClick={() => this.delete(ostaliresursi.id)} className="loginbtn">Otkazi</button>
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

export default IISOstaliResursiComponent;