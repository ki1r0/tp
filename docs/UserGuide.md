---
layout: default.md
title: "User Guide"
pageNav: 3
---

# User Guide

Welcome Financial Advisors! 👋 This guide will help you get started with FinClient.

Are you tired of juggling multiple client records and struggling to keep track of their preferences? FinClient is designed for tech-savvy financial advisors like you who prefer typing and need fast, efficient access to client details. 💡 With FinClient, managing hobbies, preferences, financial packages, and contact information has never been easier!

FinClient is a Command-Line Interface (CLI) application, or simply put, a typing-based application, that is built to help you manage your contacts and their financial details, while minimizing the time and effort spent on doing so! 🚀

Specific features include:

* 📇 Adding and deleting contacts
* ✏️ Editing your contacts' details 
* 🔍 Locating your contacts by name
* 🏢 Maintaining contact-specific details such as jobs and their workplaces  
* 📊 Sorting your contacts by name, networth, order prices and amounts
* 🕵️‍♂️ Hiding and revealing contacts  
* 📈 Estimating Call Auction clearing prices simultaneously 

You can look forward to an efficient and enjoyable experience with FinClient!

## Table of Contents
- [Quick start](#quick-start)
- [Features](#features)
    - [Viewing help](#viewing-help)
    - [Adding a person](#adding-a-person)
    - [Listing all persons](#listing-all-persons)
    - [Editing a person](#editing-a-person)
    - [Locating persons by name](#locating-persons-by-name)
    - [Deleting a person](#deleting-a-person)
    - [Hiding a person](#hiding-a-person)
    - [Revealing a person](#revealing-a-person)
    - [Limit orders and Call Auction calculator](#order)
    - [Adding remarks](#adding-remarks)
    - [Sorting contacts](#sorting-contacts)
    - [Clearing all entries](#clearing-all-entries)
    - [Exiting the program](#exiting-the-program)
    - [Saving the data](#saving-the-data)
    - [Editing the data file](#editing-the-data-file)
    - [Archiving data files](#archiving-data-files)
- [FAQ](#faq)
- [Known issues](#known-issues)
- [Command summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## <span id="quick-start">Quick start</span>

> Note:
> - "Home folder" refers to the main folder where your FinClient files are stored.
> - "cd into" means opening your command terminal and typing "cd" followed by a space and the folder path (e.g., cd /Users/yourname/Documents). Then press Enter to change the current directory.
> - "GUI" (Graphical User Interface) is the windowed application that you interact with using your mouse and keyboard.

1. Ensure you have Java `17` or above installed in your Computer.<br>
   **Mac users:** Ensure you have the precise JDK version prescribed [here](https://se-education.org/guides/tutorials/javaInstallationMac.html).

1. Download the latest `.jar` file from [here](https://github.com/AY2425S2-CS2103T-T11-4/tp/releases).

1. Find the file (called `finclient.jar`) and move it into the folder where you want your FinClient app to store data.

1. Open a command window (also known as `Terminal` on MacOS or `Command Prompt` on Windows).
   1. On Windows: Press the Windows key, type cmd, and press Enter.
   1. On Mac: Open Terminal from the Applications > Utilities folder.

1. In the command window, go to the folder where you saved the file. You do this by typing cd followed by the folder path. 
   
    For example:
   >```cd Downloads/FinClient```

1. Now, start the app by typing this and pressing Enter:
   >```java -jar finclient.jar```

   After a few seconds, a window should pop up that looks like the one below. It comes with some sample data already filled in, so you can start exploring right away.

      ![Ui](images/Ui.png)

1. Type the command in the command box (at the top of the window) and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window. Some example commands you can try (you can refer to the [Features](#features) section below for details of each command):

   * `list` : List all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Add a contact named `John Doe` to the Address Book.

   * `delete 3` : Delete the 3rd contact shown in the current list.

   * `clear` : Delete all contacts.

   * `exit` : Exit the app.

Congratulations! You've successfully finished setting up FinClient 🎉. Explore the [Features](#features), check out the [FAQ](#faq), and review the [Known issues](#known-issues) for more information 🚀.

--------------------------------------------------------------------------------------------------------------------

## <span id="features">Features</span>

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the arguments to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is an argument which can be used as `add n/John Doe`.

* Items that are in square brackets are optional, and those without square brackets are mandatory. <br>
  e.g. `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items followed by `…` can be repeated any number of times (including not at all).<br>
  e.g. `[t/TAG]…` can be used as ` `(i.e. 0 times), `t/friend`, or `t/friend t/family` etc.

* Arguments can be in any order (there is a special case for remark command, please refer [here](#adding-remarks)).<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous arguments for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.
</div>

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:**
If you are referring to a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>

### <span id="viewing-help">Viewing help : `help`</span>

Shows a message containing current available commands and provides a description on how to get more help.

Format: `help`

![help message](images/helpMsg.png)

### <span id="adding-a-person">Adding a person : `add`</span>

Adds a person to FinClient.

Format: `add n/NAME p/PHONE_NUMBER [p/PHONE_NUMBER]… e/EMAIL a/ADDRESS [r/REMARK [by/TIME]] [t/TAG]…​ [c/COMPANY] [j/job] [s/STOCKPLATFORM] [$/NETWORTH]`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:**
A person can have any number of tags (including 0)<br>
:bulb: **Tip:**
Optional fields can be left out when adding a person's contact.
</div>


Now, suppose you want to add the contact of Betsy Crowe, who is your friend. In that case, your command includes her name (`n/Betsy Crowe`), a tag indicating "friend" (`t/friend`), her email (`betsycrowe@example.com`), address (`Newgate Prison`), and phone number (`p/1234567`) along with optional remarks (`r/10 year sentence t/criminal`).

Example input:
* `add n/Betsy Crowe t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 r/10 year sentence t/criminal `

### <span id="listing-all-persons">Listing all persons : `list`</span>

Shows a list of all persons in FinClient.

Format: `list`

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:**
Although you may find list a redundant command, it can be very useful in special cases. [Explain the special cases here.]
</div>


### <span id="editing-a-person">Editing a person : `edit`</span>

Edits an existing person in FinClient.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [r/REMARK [by/TIME]] [t/TAG]…​ [c/COMPANY] [j/job] [s/STOCKPLATFORM] [$/NETWORTH]`

* Edits the person at the specified `INDEX`. The index refers to the index number shown in the displayed person list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without
    specifying any tags after it.
* For the optional fields of company, job, stock platform and networth, you can remove the existing value by typing their prefix followed with `delete`.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st person to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd person to be `Betsy Crower` and clears all existing tags.
*  `edit 2 j/delete c/LittleStartUp s/delete $/delete` Edits the job of the 2nd person to be `LittleStartUp` and clears the existing job, stock platform and networth.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:**
Tag, Company, Job, Stock Platform and Networth are all optional. You can delete these optional fields too!
</div>

### <span id="locating-persons-by-tag">Locating persons by tag: `tag`</span>

Finds persons whose tags contain any of the given tags.

Format: `find TAG_NAME`

### <span id="locating-persons-by-name">Locating persons by name: `find`</span>

Finds persons whose names contain any of the given keywords.

Format: `find KEYWORD [MORE_KEYWORDS]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* Use `list` to see all contacts again

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)

### <span id="deleting-a-person">Deleting a person : `delete`</span>

Deletes the specified person from FinClient.

Format: `delete INDEX`

* Deletes the person at the specified `INDEX`.
* The index refers to the index number shown in the displayed person list.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `delete 2` deletes the 2nd person in FinClient.
* `find Betsy` followed by `delete 1` deletes the 1st person in the results of the `find` command.

### <span id="hiding-a-person">Hiding a person : `hide`</span>

Hides the details of the specified person in FinClient.

Format: `hide all|INDEX|name`

* Hides the details of the person specified at `INDEX` or by `name`.
* Hides all contacts' details if `all` is used.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `list` followed by `hide 2` hides the 2nd person in FinClient.
* `find Betsy` followed by `hide 1` hides the 1st person in the results of the `find` command.

Before
![Ui](images/Ui.png)

After
![result for 'hide 1'](images/HideResult.png)

### <span id="revealing-a-person">Revealing a person : `reveal`</span>

Reveals the details of the specified person in FinClient.

Format: `reveal all|INDEX|name`

* Reveals the details of the person specified at `INDEX` or by `name`.
* Reveals all contacts' details if `all` is used.
* The index **must be a positive integer** 1, 2, 3, …​

Examples:
* `reveal 2` reveals the 2nd person in FinClient.
* `find Betsy` followed by `reveal 1` reveals the 1st person in the results of the `find` command.

![result for 'reveal 1'](images/RevealResult.png)

### <span id="order">Limit orders and Call Auction calculator : `order`</span>

Records a limit order for a specific contact in FinClient.

The [call auction](https://www.investopedia.com/terms/c/call-auction.asp) calculator uses the aggregated orders to determine a clearing price.

Format: `order INDEX [o/TYPE am/AMOUNT at/PRICE]`

* Records a limit order for the person specified at `INDEX`.
* The index **must be a positive number displayed beside a contact's name** 1, 2, 3, …​
* If only the index is provided, the order will be recorded as an empty order.
* The order type can be `BUY` or `SELL`.
* The amount must be a positive integer.
* The price must be a positive decimal number.

Examples:
* `order 1` records an empty order for the person listed at index 1.
* `order 1 o/buy am/10 at/9.50` records a buy order of 5 units at $5.50 for the person listed at index 1.
* `order 1 o/sell am/10 at/10.50` records a sell order of 10 units at $10.50 for the person listed at index 1.

<div markdown="span" class="alert alert-primary">

:information_source: **Design choice:**
Since FinClient is designed for a single financial instrument, every order recorded relates to that same asset.
</div>

### <span id="adding-remarks">Adding remarks: `remark`</span>

Adds a remark to the specified person in FinClient.

Format: `remark INDEX r/[REMARKS]`

* Adds a remark to the person specified at `INDEX`.
* Including the time will create a deadline for the current remark being added to the contact.

Examples:
* `remark 1 r/this is a test remark` adds `this is a test remark` to the remark section of the contact listed at index 1.
* `remark 1 r/Set buy order by/2025-10-15` adds `Set buy order` to the remark section of the contact listed at index 1 along with a deadline. <br> As the date nears, there will be a reminder shown on the main interface.

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:**
To add deadlines to remarks, the by/ argument must be supplied right after r/. 

The remark command requires `r/REMARKS by/TIME` if you wish to add a deadline. `by/TIME r/REMARKS` is not acceptable. Similarly, there should not any other arguments between these two.
</div>

### <span id="sorting-contacts">Sorting contacts: `sort`</span>

Sorts the contact list based on the criteria of name or phone number.

Format: `sort CRITERIA`

Examples:
* `sort name` sorts the contact list in FinClient based on contact's name
* `sort networth` sorts the contact list in FinClient based on contact's networth bracket

Current available criteria are:
* `name` : Sorts the contact list based on contact's name
* `networth` : Sorts the contact list based on contact's networth bracket
* `amount` : Sorts the contact list based on contact's order amount
* `price` : Sorts the contact list based on contact's order price
* `deadline`: Sorts the contact list based on contact's deadline

### <span id="clearing-all-entries">Clearing all entries : `clear`</span>

Clears all entries from the address book.

Format: `clear`

### <span id="exiting-the-program">Exiting the program : `exit`</span>

Exits the program.

Format: `exit`

### <span id="saving-the-data">Saving the data</span>

FinClient data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### <span id="editing-the-data-file">Editing the data file</span>

FinClient data are saved automatically as a JSON file `[JAR file location]/data/finclient.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">

:exclamation: **Caution:**
If your changes to the data file makes its format invalid, FinClient will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause FinClient to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

--------------------------------------------------------------------------------------------------------------------

## <span id="faq">FAQ</span>

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous FinClient home folder.

--------------------------------------------------------------------------------------------------------------------

## <span id="known-issues">Known issues</span>

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## <span id="command-summary">Command summary</span>

Action | Format | Example
---|---|---
**Add** | `add n/NAME p/PHONE_NUMBER [p/PHONE_NUMBER]… e/EMAIL a/ADDRESS [r/REMARK] [t/TAG]…​ [c/COMPANY] [j/job] [s/STOCKPLATFORM] [$/NETWORTH]` | `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague c/Engineer`
**Clear** | `clear` | `clear`
**Delete** | `delete INDEX` | `delete 3`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [r/REMARK] [t/TAG]… [c/COMPANY] [j/job] [s/STOCKPLATFORM] [$/NETWORTH]` | `edit 2 n/James Lee e/jameslee@example.com`
**Find** | `find KEYWORD [MORE_KEYWORDS]` | `find James Jake`
**Hide** | `hide all` or `hide INDEX` or `hide name` | `hide 2`
**Reveal** | `reveal all` or `reveal INDEX` or `reveal name` | `reveal 2`
**Sort** | `sort CRITERIA` | `sort name`
**Order** | `order INDEX o/TYPE am/AMOUNT at/PRICE` | `order 1 o/buy am/5 at/5.50`
**List** | `list` | `list`
**Help** | `help` | `help`
