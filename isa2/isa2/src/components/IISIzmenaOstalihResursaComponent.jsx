import React, { Component } from 'react';
import axios from 'axios';

class IISIzmenaOstalihResursaComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            id: this.props.match.params.id,
            naziv: '',
            cena: '',
            tip: '',
            boja: '',
            stil: '',
            kolicina: ''
            
        }
       
        this.changeNazivHandler = this.changeNazivHandler.bind(this);
        this.changeCenaHandler = this.changeCenaHandler.bind(this);
        this.changeTipHandler = this.changeTipHandler.bind(this);
        this.changeBojaHandler = this.changeBojaHandler.bind(this);
        this.changeStilHandler = this.changeStilHandler.bind(this);
        this.changeKolicinaHandler = this.changeKolicinaHandler.bind(this);


        //this.logout= this.logout.bind(this); 
       
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


    logout() {
        localStorage.clear();
        this.props.history.push(`/login`);

    }
    
    update(){
        let activeOstaliResurs =  JSON.parse(localStorage.getItem('activeOstaliResurs'))
        activeOstaliResurs.id =this.state.id;
        activeOstaliResurs.naziv =this.state.naziv;      
        activeOstaliResurs.cena=this.state.cena;
        activeOstaliResurs.tip  =this.state.tip;  
        activeOstaliResurs.boja=this.state.boja;
        activeOstaliResurs.stil=this.state.stil;
        activeOstaliResurs.kolicina=this.state.kolicina;

        console.log('activeOstaliResurs => ' + JSON.stringify(activeOstaliResurs));
        axios.put("http://localhost:8080/api/v1/ostaliResursi/organizator/" + activeOstaliResurs.id, activeOstaliResurs).then(response => {localStorage.setItem('activeOstaliResurs', JSON.stringify(response.data));})
    
    }

    componentDidMount(){
        let activeOstaliResurs =  JSON.parse(localStorage.getItem('activeOstaliResurs'))
        let activeUser =  JSON.parse(localStorage.getItem('activeUser'))

        if (activeUser.type != "organizator"){this.logout(); alert("Unauthorised access")}
        else{

        this.setState({
            id:activeOstaliResurs.id,
            naziv:activeOstaliResurs.naziv,
            cena:activeOstaliResurs.cena,
            tip:activeOstaliResurs.tip,
            boja:activeOstaliResurs.boja,
            stil:activeOstaliResurs.stil,
            kolicina:activeOstaliResurs.kolicina

        });
    }
        
    }
    render() {
        return (
        
            <div>
                <div className="registrationdiv">
                    <br/><br/>
                                <label> Naziv: </label>
                                <input  name="naziv" className="form-control" value={this.state.naziv} onChange={this.changeNazivHandler} />
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
                            
                                            
                                <br/>
                                <div className="center"><button className="loginbtn" onClick={()=>this.update()}>Izmeni</button></div>
                               
                                

                </div>
            </div>

        )   ;
    }
}

export default IISIzmenaOstalihResursaComponent;