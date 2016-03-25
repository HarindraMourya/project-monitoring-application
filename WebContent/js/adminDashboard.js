
    function myFunction()
    {
        document.getElementById("faculty").style.display="none";
        document.getElementById("multiplefaculty").style.display="none";
        document.getElementById("msg").style.display="block";
        document.getElementById("facultydetails").style.display="none";
        document.getElementById("studentdetails").style.display="none";
        document.getElementById("mailbox").style.display="none";
        document.getElementById("inbox").style.display="none";

    }
function faculty()
{
    document.getElementById("faculty").style.display="block";
    document.getElementById("multiplefaculty").style.display="none";
    document.getElementById("facultydetails").style.display="none";
    document.getElementById("studentdetails").style.display="none";
    document.getElementById("mailbox").style.display="none";
    document.getElementById("inbox").style.display="none";
    
}
function facultyDetails()
{
    document.getElementById("faculty").style.display="none";
    document.getElementById("multiplefaculty").style.display="none";
    document.getElementById("facultydetails").style.display="block";
    document.getElementById("studentdetails").style.display="none";
    document.getElementById("mailbox").style.display="none";
    document.getElementById("inbox").style.display="none";
    
    
}function studentDetails()
{
    document.getElementById("faculty").style.display="none";
    document.getElementById("multiplefaculty").style.display="none";
    document.getElementById("facultydetails").style.display="none";
    document.getElementById("studentdetails").style.display="block";
    document.getElementById("mailbox").style.display="none";
    document.getElementById("inbox").style.display="none";
    
}
function mutipleFaculty()
{
	document.getElementById("faculty").style.display="none";
	document.getElementById("multiplefaculty").style.display="block";
	document.getElementById("facultydetails").style.display="none";
    document.getElementById("studentdetails").style.display="none";
    document.getElementById("mailbox").style.display="none";
    document.getElementById("inbox").style.display="none";
	}
	function showMail()
	{

		document.getElementById("faculty").style.display="none";
		document.getElementById("multiplefaculty").style.display="none";
		document.getElementById("facultydetails").style.display="none";
	    document.getElementById("studentdetails").style.display="none";
	    document.getElementById("mailbox").style.display="block";
	    document.getElementById("inbox").style.display="none";
		}
	function showInbox()
	{
		document.getElementById("faculty").style.display="none";
		document.getElementById("multiplefaculty").style.display="none";
		document.getElementById("facultydetails").style.display="none";
	    document.getElementById("studentdetails").style.display="none";
	    document.getElementById("mailbox").style.display="none";
	    document.getElementById("inbox").style.display="block";
		}

