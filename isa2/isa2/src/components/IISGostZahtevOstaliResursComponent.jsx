
import axios from 'axios';
import React, { Component } from 'react';


class IISGostZahtevOstaliComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            tip: '',
            boja: '',
            stil: '',
            kolicina:'',
            dogadjajID:'',
            resursID:''

        }
        
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeBojaHandler = this.changeBojaHandler.bind(this);
        this.changeStilHandler = this.changeStilHandler.bind(this);
        this.changeKolicinaHandler = this.changeKolicinaHandler.bind(this);
        this.changeDogadjajIdHandler = this.changeDogadjajIdHandler.bind(this);
    }
    

    changeNazivHandler = (event) => {
        this.setState({ naziv: event.target.value });
    }
    changeCenaHandler = (event) => {
        this.setState({ cena: event.target.value });
    }
    changeTipHandler = (event) => {
        this.setState({ tip: event.target.value });
    }
    changeBojaHandler = (event) => {
        this.setState({ boja: event.target.value });
    }
    changeStilHandler = (event) => {
        this.setState({ stil: event.target.value });
    }
    changeKolicinaHandler = (event) => {
        this.setState({ kolicina: event.target.value });
    }
    changeDogadjajIdHandler = (event) => {
        this.setState({ dogadjajID: event.target.value });}
    
    
    posalji(dogadjajid){
        let activeOstaliResurs = JSON.parse(localStorage.getItem('activeResurs'));
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        //kreira se zahtev za resurs sa tipom ostali, datumom kada je kreiran
        
        //datum
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
        var yyyy = today.getFullYear();
        today = yyyy + '-' + mm + '-' + dd;

        let zahtev = {
            datumZahteva: today,
            tipResursa: "Ostali",
            resursID: activeOstaliResurs.id,
            gostId: activeUser.id, 
            dogadjajID: dogadjajid
        }

        console.log(zahtev);
        axios.post("http://localhost:8080/api/v1/zahteviresursa/gost", zahtev);

        
    }

    componentDidMount() {
        //let activeDogadjaj =  JSON.parse(localStorage.getItem('activeDogadjaj'))
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'));
        
        if (activeUser.type == "gost" )
        {
        let activeOstaliResurs =  JSON.parse(localStorage.getItem('activeResurs'));
        this.setState({
            id:activeOstaliResurs.id,
            naziv:activeOstaliResurs.naziv,
            cena:activeOstaliResurs.cena,
            tip:activeOstaliResurs.tip,
            boja:activeOstaliResurs.boja,
            stil:activeOstaliResurs.stil,
            kolicina:activeOstaliResurs.kolicina,
            resursID:activeOstaliResurs.resursID
        });
    } 
    else{this.logout(); alert("Unauthorised access")} 
    }
    render() {
        return (
            <div>
                <h2 className='text-center'>Ostali resurs</h2>
                
                <div style={{position:'absolute',top:'100px',left:'35%'}} className="registrationdiv">
                    <br /><br />
                    <label> Naziv: </label>
                    <input name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
                    <label> Cena: </label>
                    <input name="cena" className="form-control" value={this.state.cena} onChange={this.changeCenaHandler} />
                    <label> Tip: </label>
                    <input name="tip" className="form-control" value={this.state.tip} onChange={this.changeTipHandler} />
                    <label>Boja: </label>
                    <input name="boja" className="form-control" value={this.state.boja} onChange={this.changeBojaHandler} />
                    <label> Stil: </label>
                    <input name="stil" className="form-control" value={this.state.stil} onChange={this.changeStilHandler} />
                    <label> Kolicina: </label>
                    <input name="kolicina" className="form-control" value={this.state.kolicina} onChange={this.changeKolicinaHandler} />
                    <label> Dogadjaj id: </label>
                    <input name="dogadjajId" className="form-control" value={this.state.dogadjajID} onChange={this.changeDogadjajIdHandler} />
                    
                    <br />
                    <button onClick={() => this.posalji(this.state.dogadjajID)} className="loginbtn">Posalji</button>

                </div>
                
            </div>
        );
    }
}

export default IISGostZahtevOstaliComponent;