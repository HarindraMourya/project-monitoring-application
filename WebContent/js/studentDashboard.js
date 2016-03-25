
    function myFunction()
    {
        document.getElementById("msg").style.display="block";
        document.getElementById("mailbox").style.display="none";
        document.getElementById("inbox").style.display="none";
        document.getElementById("addproject").style.display="none"
        	document.getElementById("project").style.display="none";
    		

    }
    function showMail()
	{

		document.getElementById("mailbox").style.display="block";
	    document.getElementById("inbox").style.display="none";
	    document.getElementById("addproject").style.display="none"
	    	document.getElementById("project").style.display="none";
			
		}
	function showInbox()
	{
		document.getElementById("mailbox").style.display="none";
	    document.getElementById("inbox").style.display="block";
	    document.getElementById("addproject").style.display="none"
	    	document.getElementById("project").style.display="none";
		}
	function addproject()
	{

		document.getElementById("addproject").style.display="block";
		document.getElementById("mailbox").style.display="none";
	    document.getElementById("inbox").style.display="none";
	    document.getElementById("project").style.display="none";
		}
	function showProject()
	{
		document.getElementById("addproject").style.display="none";
		document.getElementById("mailbox").style.display="none";
	    document.getElementById("inbox").style.display="none";
	    document.getElementById("project").style.display="block";
	}
	
    