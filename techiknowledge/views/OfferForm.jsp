
<form id="offerform" class="basic-grey">
    <h1>Post Your Request Here!
        <span>Please fill all the texts in the fields.</span>
    </h1>
    <label>
        <span>Title :</span>
        <input id="title" type="text" name="title" placeholder="A Descriptive Title" required="required"/>
    </label>
   
    <label>
        <span>Offer Pay:</span>
        <input id="pay" type="text" name="pay" placeholder="Pay Amount in $" required="required" title="Numbers" pattern="\d+"/>
    </label>
   	<label>
        <span>Service Type :</span>
        <select id="servType" name="servType">
        <option value="network">Network</option>
        <option value="software">Software</option>
        <option value="hardware">Hardware</option>
        <option value="others">Others</option>
        </select>
    </label>
    <label>
        <span>Description:</span>
        <textarea id="description" name="description" placeholder="Brief Description of Your Request" required="required"></textarea>
    </label>   
     <label>
        <span>&nbsp;</span>
        <input id="post-request" type="submit" class="button" value="Post" />
    </label>    
</form>		