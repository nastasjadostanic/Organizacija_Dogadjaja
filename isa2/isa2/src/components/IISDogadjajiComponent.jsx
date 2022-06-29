import axios from 'axios';
import React, { Component } from 'react';
import DogadjajService from '../services/DogadjajService';

class DogadjajiComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {

           dogadjaji: []

        }
        this.addDogadjaj = this.addDogadjaj.bind(this);
        this.viewDogadjaj = this.viewDogadjaj.bind(this);
        this.deleteDogadjaj = this.deleteDogadjaj.bind(this);
    }
    deleteDogadjaj(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        DogadjajService.deleteDogadjaj(id,activeUser.type).then(res => {
            this.setState({ dogadjaji: this.state.dogadjaji.filter(dogadjaj => dogadjaj.id !== id) });
             
        });
        window.location.refresh();
    }
    
    addDogadjaj() {
        this.props.history.push("/dodajdogadjaj");
    }
    viewDogadjaj(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios
        .get("http://localhost:8080/api/v1/dogadjaji/" + activeUser.type + '/' + id )
        .then(response => {
            localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
            this.props.history.push(`/viewDogadjaj`);
        });
 
    }
    
    viewSala(salaID, dogadjajID) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));

        axios
        .get("http://localhost:8080/api/v1/dogadjaji/" + dogadjajID)
        .then(response => {
            localStorage.setItem('activeDogadjaj',JSON.stringify(response.data));
        });

        axios
        .get("http://localhost:8080/api/v1/sale/sala/" + salaID)
        .then(response => {
            localStorage.setItem('activeSala',JSON.stringify(response.data));
            
            this.props.history.push(`/sala`);
        });

        
 
    }
    viewLjudskiResursi(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
    
        axios
        .get("http://localhost:8080/api/v1/ljudskiResursi/id/organizator/" + id )
        .then(response => {
            localStorage.setItem('activeResurs',JSON.stringify(response.data));
            this.props.history.push(`/vidiljudski`);
        });

       
    }
    viewOstaliResursi(id) {
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        axios
        .get("http://localhost:8080/api/v1/ostaliResursi/id/organizator/" + id )
        .then(response => {
            localStorage.setItem('activeResurs',JSON.stringify(response.data));
            this.props.history.push(`/vidiostali`);
        });
 
    }
    delete(id) {
        axios.delete("http://localhost:8080/api/v1/dogadjaji/" + id);
        window.location.reload();
    }
    update(id) {

        axios
            .get("http://localhost:8080/api/v1/dogadjaji/" + id)
            .then(response => {
                localStorage.setItem('activeDogadjaj', JSON.stringify(response.data));
                this.props.history.push(`/izmenadogadjaja`);
            });


    }
    
    componentDidMount() {
       
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "organizator" ){
        
           axios.get("http://localhost:8080/api/v1/dogadjaji").then((res) => {
                this.setState({ dogadjaji: res.data });
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
                <button style={{position:'absolute', top:'150px', left:'1480px'}} onClick={() => this.addDogadjaj(this.props.match.params.id)} className="loginbtn">Add</button>
       
                

                <h2 style={{position:'absolute',top:'100px',left:'45%'}} className="text-center">Dogadjaji</h2>

                <div className="row">
                    <table style={{position:'absolute', left:'0px',top:'200px'}} className="table table-striped table-borderd">
                        <thead>
                            <tr>
                                <th>Ukupna cena</th>
                                <th>Datum naplate</th>
                                <th>Datum odrzavanja</th>
                                <th>Vreme odrzavanja</th>
                                <th>Trajanje</th>
                                <th>Tip</th>
                                

                                
                                <th>Sala</th>
                                <th>Ljudski resurs</th>
                                <th>Ostali resurs</th>
                                <th>Akcija</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.dogadjaji.map(
                                    dogadjaji =>
                                        <tr key={dogadjaji.id}>
                                            <td>{dogadjaji.ukupnaCena} </td>
                                            <td>{dogadjaji.datumNaplate}</td>
                                            <td>{dogadjaji.datumOdrzavanja}</td>
                                            <td>{dogadjaji.vremeOdrzavanja}</td>
                                            <td>{dogadjaji.trajanje}</td>
                                            <td>{dogadjaji.tip}</td>

                                                <td><button onClick={() => this.viewSala(dogadjaji.salaID, dogadjaji.id)} className="loginbtn">Vidi</button></td>
                                                <td><button onClick={() => this.viewLjudskiResursi(dogadjaji.ljudskiResursId)} className="loginbtn">Vidi</button></td>
                                                <td><button onClick={() => this.viewOstaliResursi(dogadjaji.ostaliResursId)} className="loginbtn">Vidi</button></td>

                                                <td>
                                                    <button onClick={() => this.update(dogadjaji.id)} className="loginbtn">Izmeni</button>
                                                    <button onClick={() => this.delete(dogadjaji.id)} className="loginbtn">Otkazi</button>
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

export default DogadjajiComponent;