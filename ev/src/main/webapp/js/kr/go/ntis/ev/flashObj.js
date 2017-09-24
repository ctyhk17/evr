
/*
IE Flash ActiveContent Activation Script
Author: Faisal Iqbal (chall3ng3r)
Blog: http://www.orison.biz/blog/chall3ng3r/

Feel free to modify or distribute.
*/
 
/*
Method: FlashObject
 Param1: SWF path
 Param2: Movie width
 Param3: Movie height
 Param4: BGColor
 Param5: Flashvars (Optional)
*/
function FlashObject(swf, width, height, flashvars)
{
    var strFlashTag = new String();
    
    if (navigator.appName.indexOf("Microsoft") != -1)
    {
        strFlashTag += '<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" ';
        strFlashTag += 'codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=version=8,0,0,0" width="' + width + '" height="' + height + '">';
        strFlashTag += '<param name="movie" value="' + swf + '"/>';        
        strFlashTag += '<param name="FlashVars" value="' + flashvars + '"/>';
        strFlashTag += '<param name="quality" value="best"/>';
        //strFlashTag += '<param name="bgcolor" value="' + bgcolor + '"/>';
        strFlashTag += '<param name="menu" value="false"/>';
        strFlashTag += '<param name="salign" value="LT"/>';
        strFlashTag += '<param name="scale" value="noscale"/>';
        strFlashTag += '<param name="wmode" value="transparent"/>';
        strFlashTag += '<param name="allowScriptAccess" value="sameDomain"/>';
        strFlashTag += '</object>';
    }
    else
    {
        strFlashTag += '<embed src="' + swf + '" ';
        strFlashTag += 'quality="best" ';
        //strFlashTag += 'bgcolor="' + bgcolor + '" ';
        strFlashTag += 'width="' + width + '" ';
        strFlashTag += 'height="' + height + '" ';
        strFlashTag += 'menu="false" ';
        strFlashTag += 'scale="noscale" ';
        strFlashTag += 'salign="LT" ';
        strFlashTag += 'wmode="transparent" ';
        strFlashTag += 'allowScriptAccess="sameDomain" ';
        strFlashTag += '<param name="FlashVars" value="' + flashvars + '"/>';
        strFlashTag += 'type="application/x-shockwave-flash" ';
        strFlashTag += 'pluginspage="http://www.macromedia.com/go/getflashplayer">';
        strFlashTag += '</embed>';
    }

 document.write(strFlashTag);
}
 
  
